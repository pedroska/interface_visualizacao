package teste;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 *
 * @author Pedro Ivo
 */
@ManagedBean(name="reasonerSQL")
@ViewScoped
public class ReasonerSQL{
    
    @PostConstruct
    public void init() {
        
        try {
            reasoner();
        } catch (ParserConfigurationException | SAXException ex) {
            Logger.getLogger(ReasonerSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void reasoner() throws ParserConfigurationException, SAXException{
      
        try {    
            URL url = new URL("http://localhost:8080/visualizacao_semantica_estrutural/resources/reasoner");
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
