import java.util.Date;

interface EmployeeInterface{
    void start(Date d);
    void terminate(Date d);
    void work();
    String name();
}

class Employee implements EmployeeInterface{
    private String name;

    Employee(String name){
        this.name=name;
    }

    @Override public void start(Date d){
        System.out.print("\n"+name+" started on "+d.toString());
    }

    @Override public void terminate(Date d){
        System.out.print("\n"+name+" stoped on "+d.toString());
    }

    @Override public void work(){
        System.out.print("\n"+name+" worked ");
    }

    public String name(){
        return name;
    }
}

abstract class EmpDecorator implements EmployeeInterface{
    protected EmployeeInterface emp;

    EmpDecorator(EmployeeInterface emp){
        this.emp=emp;
    }

    public void start(Date d){
        emp.start(d);
    }
    public void terminate(Date d){
        emp.terminate(d);
    }
    public void work(){
        emp.work();
    }
    public String name(){
        return emp.name();
    }
}

class TeamMember extends EmpDecorator{
    
    TeamMember(EmployeeInterface emp){ super(emp); }

    @Override public void work(){
        emp.work();
        System.out.print("as TeamMember ");
    }

    public void colaborate(){
        System.out.print("\n"+emp.name()+" colaborated!");
    }
}

class TeamLeader extends EmpDecorator{
    
    TeamLeader(EmployeeInterface emp){ super(emp); }

    @Override public void work(){
        emp.work();
        System.out.print("as TeamLeader ");
    }

    public void plan(){
        System.out.print("\n"+emp.name()+" planed!");
    }
}

class Manager extends EmpDecorator{
    
    Manager(EmployeeInterface emp){ super(emp); }

    @Override public void work(){
        emp.work();
        System.out.print("as Manager ");
    }

    public void manage(){
        System.out.print("\n"+emp.name()+" managed!");
    }
}