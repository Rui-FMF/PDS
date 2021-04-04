import java.util.ArrayList;
import java.util.List;

public class SocialSecurity {
    private List<Employee> EmpArray;

    public SocialSecurity() {
        EmpArray = new ArrayList<Employee>();
    }

    public void regist(Employee e) {
        if (EmpArray.contains(e)) {
            System.out.println("Employee " + e.getName() + " already registed in social security");
            return;
        } 
        else {
            EmpArray.add(e);
            System.out.println("Employee " + e.getName() + " registed in social security");
            return;
        }
    }

    public List getSocialSecurityPersons() {
        return EmpArray;
    }
}