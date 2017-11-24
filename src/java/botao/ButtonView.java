package botao;
 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
 
@ManagedBean
public class ButtonView {
    
    public void createNewRule(String ind1, String property, String ind2){
        try {    
            URL url = new URL("http://localhost:8080/visualizacao_semantica_estrutural/resources"
                    + "/cria_regra/"+ind1+"/"+property+"/"+ind2);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "text/plain");
            BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
            //String output = "", captura;
            //captura = br.readLine();
            conn.disconnect();
            
        }catch (IOException e) {
        } 
        
        addMessage("Nova Regra: "+ind1+" -> "+property+" -> "+ind2+" criada com sucesso!!!");
    }
    
    public void buttonAction(ActionEvent actionEvent) {
        addMessage("Welcome to Primefaces!!");
    }
     
    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}