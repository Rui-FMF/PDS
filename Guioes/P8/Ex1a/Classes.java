import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

interface BankAccount {
    void deposit(Double amount);

    boolean withdraw(Double amount);

    Double balance();
}

class BankAccountImpl implements BankAccount {
    private String bank;
    private Double balance;

    BankAccountImpl(String bank, Double initialDeposit) {
        this.bank = bank;
        balance = initialDeposit;
    }

    public String getBank() {
        return bank;
    }

    @Override
    public void deposit(Double amount) {
        balance += amount;
    }

    @Override
    public boolean withdraw(Double amount) {
        if (amount > balance)
            return false;
        balance -= amount;
        return true;
    }
    

    @Override
    public Double balance() {
        return balance;
    }
}

class Person {
    private String name;
    private BankAccount bankAccount;

    public Person(String n) {
        name = n;
        bankAccount = new BankAccProxy("PeDeMeia", 0.0);
    }

    public String getName() {
        return name;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }
}

class Employee extends Person {
    private Double salary;

    public Employee(String n, Double s) {
        super(n);
        salary = s;
    }

    public Double getSalary() {
        return salary;
    }
}

enum User {
    OWNER, COMPANY
}

class Company {
    public static User user;
    private List<Employee> emps = new ArrayList<>();

    public void admitPerson(String name, Double salary) {
        Employee e = new Employee(name, salary);
        emps.add(e);
    }

    public void paySalaries(int month) {
        for (Employee e : emps) {
            BankAccount ba = e.getBankAccount();
            ba.deposit(e.getSalary());
        }
    }

    public List<Employee> employees() {
        return Collections.unmodifiableList(emps);
    }
}