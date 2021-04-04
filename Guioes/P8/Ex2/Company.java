import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

enum User {
    OWNER, COMPANY
}

class Company {
    public static User user;
    private List<Employee> emps = new ArrayList<>();
    private List<Card> cards = new ArrayList<>();
    private SocialSecurity ss = new SocialSecurity();
    private Insurance insurance = new Insurance();
    private Parking parking = new Parking();
    


    public void admitEmployee(Person p, double salary) {
        Employee e = new Employee(p, Double.valueOf(salary));
        emps.add(e);
        Card c = new Card(p.getName());
        cards.add(c);
        System.out.println(c.getCard());

        ss.regist(e);
        insurance.regist(e);
        parking.allow(e);
    }

    public void paySalaries(int month) {
        for (Employee e : emps) {
            e.payEmployee(e.getSalary());
        }
    }

    public List<Employee> employees() {
        return Collections.unmodifiableList(emps);
    }
}