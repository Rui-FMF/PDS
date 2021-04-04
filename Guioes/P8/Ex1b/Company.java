import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

enum User {
    OWNER, COMPANY
}

class Company {
    public static User user;
    private List<Employee> emps = new ArrayList<>();

    public void admitEmployee(Person p, double salary) {
        Employee e = new Employee(p, Double.valueOf(salary));
        emps.add(e);
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