/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import thing.GerencialNucleo;

/**
 *
 * @author Pedro Ivo
 */
@ManagedBean(name="consumeGerenciais")
@ViewScoped
public class ConsumeGerencialNucleo implements Serializable{
    
    private ArrayList<GerencialNucleo> nucleos;
     
    @PostConstruct
    public void init() {
        
        this.nucleos = new ArrayList<>();
        
        try {
            this.nucleos = RetornaNucleos();
        } catch (ParserConfigurationException | SAXException ex) {
            Logger.getLogger(ConsumeGerencialNucleo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
    public ArrayList<GerencialNucleo> getNucleos() {
        return nucleos;
    }
    
    public ArrayList<GerencialNucleo> RetornaNucleos() throws ParserConfigurationException, SAXException{
        
        ArrayList<GerencialNucleo> nucls = new ArrayList<>();
        
        try {    
            URL url = new URL("http://localhost:8080/visualizacao_semantica_estrutural/resources/gerencial");
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
                
                NodeList nodes = document.getElementsByTagName("gerencialNucleo");
                
                for(int i = 0; i < nodes.getLength(); i++){
                    if(nodes.item(i).getChildNodes().getLength() == 3){
                        GerencialNucleo nuc = new GerencialNucleo(
                                nodes.item(i).getChildNodes().item(2).getTextContent(),
                                nodes.item(i).getChildNodes().item(1).getTextContent(),                           
                                nodes.item(i).getChildNodes().item(0).getTextContent()
                        );
                        nucls.add(nuc);
                    }
                }
               
            }catch (ParserConfigurationException | SAXException | IOException | DOMException | NumberFormatException e) {
            }
            }catch (MalformedURLException e) {
            }catch (IOException e) {
            }        
        return nucls;    
    }
}
