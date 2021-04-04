import java.util.List;

public class SharkCompany {
    public static void main(String[] args) {
        System.out.println("\nCompany\n>");

        Company shark = new Company();
        Company.user = User.COMPANY;
        shark.admitPerson("Maria Silva", 1000.0);
        shark.admitPerson("Manuel Pereira", 900.0);
        shark.admitPerson("Aurora Machado", 1200.0);
        shark.admitPerson("Augusto Lima", 1100.0);
        List<Employee> sharkEmps = shark.employees();
        for (Employee e : sharkEmps)
            // "talking to strangers", but this is not a normal case
            System.out.println(e.getBankAccount().balance());
            
        shark.paySalaries(1);

        for (Employee e : sharkEmps) {
            e.getBankAccount().withdraw(500.0);
            System.out.println(e.getBankAccount().balance());
        }

        System.out.println("\nUSER\n>");

        Company shark2 = new Company();
        Company.user = User.OWNER;
        shark2.admitPerson("Maria Silva", 1000.0);
        shark2.admitPerson("Manuel Pereira", 900.0);
        shark2.admitPerson("Aurora Machado", 1200.0);
        shark2.admitPerson("Augusto Lima", 1100.0);
        List<Employee> sharkEmps2 = shark2.employees();
        for (Employee e : sharkEmps2)
            // "talking to strangers", but this is not a normal case
            System.out.println(e.getBankAccount().balance());
            
        shark2.paySalaries(1);

        for (Employee e : sharkEmps2) {
            e.getBankAccount().withdraw(500.0);
            System.out.println(e.getBankAccount().balance());
        }
    }
}