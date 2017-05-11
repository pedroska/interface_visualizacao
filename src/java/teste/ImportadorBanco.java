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
@ManagedBean(name="importadorBanco")
@ViewScoped
public class ImportadorBanco{
    
    private ArrayList<ControleLeiteiro> controles;
     
    @PostConstruct
    public void init() {
        
        try {
            importaBanco();
        } catch (ParserConfigurationException | SAXException ex) {
            Logger.getLogger(ImportadorBanco.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
    public ArrayList<ControleLeiteiro> getControles() {
        return controles;
    }
    
    public void importaBanco() throws ParserConfigurationException, SAXException{
        
        ArrayList<ControleLeiteiro> ctrls = new ArrayList<>();
        
        try {    
            URL url = new URL("http://localhost:8080/visualizacao_semantica_estrutural/resources/sql");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "text/plain");
            BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
            String output = "", captura;
            captura = br.readLine();
            while (captura != null) {
		output+=captura;
                output+="\n";
                captura = br.readLine();
            }

            conn.disconnect();
            
            }catch (MalformedURLException e) {
            }catch (IOException e) {
            }            
    }
    
}
