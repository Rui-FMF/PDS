import java.util.ArrayList;
import java.util.List;

public class Insurance {
    private List<Employee> segurados;
    public Insurance() {
        segurados = new ArrayList<Employee>();
    }
    public void regist(Employee e) {
        if (segurados.contains(e)) {
            System.out.println("Employee " + e.getName() + " already was registered to Insurance");
            return;
        } 
        else {
            segurados.add(e);
            System.out.println("Employee " + e.getName() + " registered to Insurance");
            return;
        }
    }

    public List getInsurancePersons() {
        return segurados;
    }
}