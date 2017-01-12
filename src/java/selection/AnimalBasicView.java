package selection;
 
import thing.Animal;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

@ManagedBean(name="animalBasicView")
@ViewScoped
public class AnimalBasicView implements Serializable {
     
    private ArrayList<Animal> animals;
     
    //@ManagedProperty("#{animalService}")
    //private AnimalService service;
 
    @PostConstruct
    public void init() {
        
        this.animals = new ArrayList<>();
        
        for(int i=0;i<8;i++){
            String num = UUID.randomUUID().toString().substring(0, 8);
            Animal a = new Animal("animal"+num,i,(float)Math.random());
            
            animals.add(a);
        }
    }
     
    public List<Animal> getAnimals() {
        return animals;
    }
    
    /*public void setAnimals(ArrayList<Animal> a){
        this.animals = a;
    }*/
 
    //public void setService(CarService service) {
    //    this.service = service;
    //}
}