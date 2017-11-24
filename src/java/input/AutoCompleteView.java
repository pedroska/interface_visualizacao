package input;
 
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
 
import org.primefaces.event.SelectEvent;
 
@ManagedBean
public class AutoCompleteView {
     
    private String ind1;
    private String ind2;
    private String relacao;
    private Property property;
    private List<Property> selectedProperties;
     
    @ManagedProperty("#{propertyService}")
    private PropertyService service;
     
    public List<String> completeText(String query) {
        List<String> results = new ArrayList<>();
        for(int i = 0; i < 10; i++) {
            results.add(query + i);
        }
         
        return results;
    }
     
    public List<Property> completeProperty(String query) {
        List<Property> allProperties = service.getProperties();
        List<Property> filteredProperties = new ArrayList<Property>();
         
        for (int i = 0; i < allProperties.size(); i++) {
            Property skin = allProperties.get(i);
            if(skin.getProperty().toLowerCase().startsWith(query)) {
                filteredProperties.add(skin);
            }
        }
         
        return filteredProperties;
    }
     
    public void onItemSelect(SelectEvent event) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Item Selected", event.getObject().toString()));
    }

    //Gambiarra
    public String getRelacao() {
        return relacao;
    }

    public void setRelacao(String relacao) {
        this.relacao = relacao;
    }
    //-----
    
    
    public String getInd1() {
        return ind1;
    }
 
    public void setInd1(String ind1) {
        this.ind1 = ind1;
    }
 
    public String getInd2() {
        return ind2;
    }
 
    public void setInd2(String ind2) {
        this.ind2 = ind2;
    }

    public Property getProperty() {
        return property;
    }
 
    public void setProperty(Property property) {
        this.property = property;
    }
 
    public List<Property> getSelectedProperties() {
        return selectedProperties;
    }
 
    public void setSelectedProperties(List<Property> selectedProperties) {
        this.selectedProperties = selectedProperties;
    }
     
    public void setService(PropertyService service) {
        this.service = service;
    }
 
    public char getPropertyGroup(Property property) {
        return property.getProperty().charAt(0);
    }
}