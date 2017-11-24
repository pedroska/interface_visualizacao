package input;
 
public class Property {
 
    //Propriedade tem um domínio e um range
    private String ind1;   
    private String property;  
    private String ind2;
   
    public Property() {}
 
    public Property(String ind1, String property, String ind2) {
        this.ind1 = ind1;
        this.property = property;
        this.ind2 = ind2;
    }
 
    public String getInd1() {
        return ind1;
    }
 
    public void setInd1(String ind1) {
        this.ind1 = ind1;
    }
 
    public String getProperty() {
        return property;
    }
 
    public void setProperty(String property) {
        this.property = property;
    }
 
    public String getInd2() {
        return ind2;
    }
 
    public void setInd2(String ind2) {
        this.ind2 = ind2;
    }
     
    @Override
    public String toString() {
        return property;
    }
}