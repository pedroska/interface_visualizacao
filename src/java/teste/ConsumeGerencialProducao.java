package teste;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import thing.ControleLeiteiro;
import thing.GerencialNucleo;
import thing.GerencialProducao;
import thing.ProducaoRebanho;

/**
 *
 * @author Pedro Ivo
 */
@ManagedBean(name="consumeGerencialProducao")
@ViewScoped
public class ConsumeGerencialProducao implements Serializable{
    
    private ArrayList<GerencialProducao> nucleos;
     
    @PostConstruct
    public void init() {
        
        this.nucleos = new ArrayList<>();
        
        try {
            this.nucleos = RetornaGerencialProducao();
        } catch (ParserConfigurationException | SAXException ex) {
            Logger.getLogger(ConsumeGerencialNucleo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
    public ArrayList<GerencialProducao> getNucleos() {
        return nucleos;
    }
    
    public ArrayList<GerencialProducao> RetornaGerencialProducao() throws ParserConfigurationException, SAXException{
        
        ArrayList<GerencialProducao> gers = new ArrayList<>();
        
        try {
            URL url = new URL("http://localhost:8080/visualizacao_semantica_estrutural/resources/gerencial_producao");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/xml");
            BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
            String output = "", captura;
            captura = br.readLine();
            while (captura != null) {
		output+=captura;
                output+="\n";
                captura = br.readLine();
            }

            conn.disconnect();
            
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();  
            DocumentBuilder builder;  
            try{  
                builder = factory.newDocumentBuilder();  
                Document document = builder.parse( new InputSource( new StringReader( output ) ) );
                
                NodeList nodes = document.getElementsByTagName("gerencialProducao");
                
                for(int i = 0; i < nodes.getLength(); i++){
                        GerencialProducao ger = new GerencialProducao(
                                nodes.item(i).getChildNodes().item(2).getTextContent(),
                                nodes.item(i).getChildNodes().item(1).getTextContent(),
                                nodes.item(i).getChildNodes().item(0).getTextContent(),
                                Float.parseFloat(nodes.item(i).getChildNodes().item(3).getTextContent())                           
                        );
                        gers.add(ger);
                    
                }
               
            }catch (ParserConfigurationException | SAXException | IOException | DOMException | NumberFormatException e) {
            }
            }catch (MalformedURLException e) {
            }catch (IOException e) {
            }        
        return gers;    
    }
}