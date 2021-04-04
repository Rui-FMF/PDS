import java.util.Date;
public class Test{
    public static void main(String args[]) {
        EmployeeInterface e1 = new Employee("Rui");
        TeamMember tm1 = new TeamMember(new Employee("Luis"));
        TeamLeader tl1 = new TeamLeader(new Employee("Ana"));
        TeamLeader tl2 = new TeamLeader(e1);
        TeamLeader tl3 = new TeamLeader(tm1);
        Manager m1 = new Manager(e1);
        Manager m2 = new Manager(
        new TeamLeader(
        new TeamMember(
        new Employee("Bruna"))));

        EmployeeInterface lista[] = { e1, tm1, tl1, tl2, tl3, m1, m2 };
        for (EmployeeInterface e: lista)
            e.work();

        tm1.start(new Date(2020,04,10));
        tm1.work();
        tm1.colaborate();
        tl1.plan();
        tm1.terminate(new Date(2020,04,20));
        m1.manage();
        System.out.println();
    }

}