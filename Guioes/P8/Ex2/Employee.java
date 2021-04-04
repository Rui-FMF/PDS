class Employee {
    private Double salary;
    private Person person;

    public Employee(Person p, Double s) {
        person = p;
        salary = s;
    }

    public Double getSalary() {
        return salary;
    }

    public void payEmployee(Double ammount) {
        BankAccount ba = person.getBankAccount();
        ba.deposit(ammount);
    }

    public String getName(){
        return person.getName();
    }
}