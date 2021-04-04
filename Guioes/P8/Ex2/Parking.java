import java.util.ArrayList;

public class Parking{
    private ArrayList<Employee> allowed;
    public Parking() {
        allowed = new ArrayList<Employee>();
    }
    public void allow(Employee e){
        if(allowed.contains(e)){
            System.out.println("Employee " + e.getName() + " already has acces to parking");
            return ;
        } 
        else{
            allowed.add(e);
            System.out.println("Employee " + e.getName() + " allowed to Park");
            return ;
        }
    }

    public ArrayList<Employee> getAllowed(){
        return allowed;
    }
}