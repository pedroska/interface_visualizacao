package teste;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
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

/**
 *
 * @author Pedro Ivo
 */
@ManagedBean(name="consumeControles")
@ViewScoped
public class ConsumeControles implements Serializable {
    
    private ArrayList<ControleLeiteiro> controles;
     
    @PostConstruct
    public void init() {
        
        this.controles = new ArrayList<>();
        
        try {
            this.controles = RetornaAnimais();
        } catch (ParserConfigurationException | SAXException ex) {
            Logger.getLogger(ConsumeControles.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
    public ArrayList<ControleLeiteiro> getControles() {
        return controles;
    }
    
    public ArrayList<ControleLeiteiro> RetornaAnimais() throws ParserConfigurationException, SAXException{
        
        ArrayList<ControleLeiteiro> ctrls = new ArrayList<>();
        
        try {    
            URL url = new URL("http://localhost:8080/visualizacao_semantica_estrutural/resources/controle");
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
                
                NodeList nodes = document.getElementsByTagName("controleLeiteiro");
                
                for(int i = 0; i < nodes.getLength(); i++){
                    /*
                    ControleLeiteiro cl = new ControleLeiteiro(
                            nodes.item(i).getChildNodes().item(0).getNodeValue(),
                            Float.parseFloat(nodes.item(i).getChildNodes().item(1).getNodeValue()),
                            Float.parseFloat(nodes.item(i).getChildNodes().item(2).getNodeValue()),
                            Float.parseFloat(nodes.item(i).getChildNodes().item(3).getNodeValue()),
                            Integer.parseInt(nodes.item(i).getChildNodes().item(4).getNodeValue()),
                            Integer.parseInt(nodes.item(i).getChildNodes().item(5).getNodeValue())
                    );
                    */
                    ControleLeiteiro cl = new ControleLeiteiro(
                            nodes.item(i).getChildNodes().item(0).getTextContent(),
                            Float.parseFloat(nodes.item(i).getChildNodes().item(1).getTextContent()),                            
                            Float.parseFloat(nodes.item(i).getChildNodes().item(2).getTextContent()),
                            Float.parseFloat(nodes.item(i).getChildNodes().item(3).getTextContent()),
                            Integer.parseInt(nodes.item(i).getChildNodes().item(4).getTextContent()),
                            Integer.parseInt(nodes.item(i).getChildNodes().item(5).getTextContent())
                    );
                    ctrls.add(cl);
                }
               
            }catch (ParserConfigurationException | SAXException | IOException | DOMException | NumberFormatException e) {
            }
            }catch (MalformedURLException e) {
            }catch (IOException e) {
            }        
        return ctrls;    
    }
    
}
