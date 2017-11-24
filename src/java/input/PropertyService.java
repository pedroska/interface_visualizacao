package input;
 
import java.util.ArrayList;
import java.util.List;
 
import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
  
@ManagedBean(name="propertyService", eager = true)
@ApplicationScoped
public class PropertyService {
     
    private List<Property> properties;
     
    @PostConstruct
    public void init() {
        properties = new ArrayList<Property>();
        //Inclusão de todos as properties aqui (busca na ontologia - webservice)
        properties.add(new Property("ind2", "property1", "ind1"));
        properties.add(new Property("ind1", "property2", "ind2"));
    }
     
    public List<Property> getProperties() {
        return properties;
    } 
}