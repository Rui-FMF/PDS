// import the ArrayList class
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Empregado e1 = new Empregado("Zé", "Caricas", 1, 1.50);
        Empregado e2 = new Empregado("Manel", "da Mala", 2, 5.50);
        Empregado e3 = new Empregado("Maria", "Albertina", 3, 420.69);
        Empregado e4 = new Empregado("Adolfo", "Dias", 4, 999.99);

        Registos registo = new Registos();
        registo.insere(e1);
        registo.insere(e2);
        registo.insere(e3);

        registo.isEmpregado(1);
        registo.isEmpregado(4);

        registo.remove(1);

        registo.isEmpregado(1);

        List<Empregado> empregados = registo.listaDeEmpregados();

        for (Empregado e : empregados) {
            System.out.println(e.nome() + " " + e.apelido() + " " + e.codigo() + " " + e.salario());
        }

        // ---------------
        Employee emp1 = new Employee("Diogo Gomes", 1, 5000);
        Employee emp2 = new Employee("Sousa Pinto", 2, 7000);
        Employee emp3 = new Employee("Carlos Costa", 3, 9000);

        Database db = new Database();

        db.addEmployee(emp1);
        db.addEmployee(emp2);
        db.addEmployee(emp3);

        for (Employee e : db.getAllEmployees())
            System.out.println(e.getName() + " " + " " + e.getEmpNum() + " " + e.getSalary());

        db.deleteEmployee(2);

        for (Employee e : db.getAllEmployees())
            System.out.println(e.getName() + " " + " " + e.getEmpNum() + " " + e.getSalary());
		      	
      	Adapter a = new Adapter(registo, db);
      	
      	a.printAll();
        System.out.println("-----------");
          
      	a.addEmployee(e4);
      
      	Empregado e5 = new Empregado("Jacinto", "Manuelito", 99, 12345.999);
      	a.addEmployee(e5);
      	a.removeEmployee(e3.codigo());
      	a.printAll();
        System.out.println(a.isInCompany(e1.codigo()));
        System.out.println(a.isInCompany(e2.codigo()));
    }
}