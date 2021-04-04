import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

class Employee {
    private String name; 
    private long emp_num; 
    private double salary;
    public Employee(String name, long emp_num, double salary) { 
        this.name = name;
        this.emp_num = emp_num;
        this.salary = salary; 
    }
  
    public String getName() { 
        return name;
    }
  
    public long getEmpNum() {
    return emp_num; 
    }
    
  public double getSalary() {
    return salary;
  } 
}

class Database { // Data elements
	private Vector<Employee> employees; // Stores the employees
  
  public Database() {
  	employees = new Vector<>();
  }
  
  public boolean addEmployee(Employee employee) {
  	return employees.add(employee);
  }
  
  public void deleteEmployee(long emp_num) {
		for(Employee emp : employees) 
      if(emp.getEmpNum() == emp_num){
        employees.remove(emp);
        return;
      }
  }
  
  public Employee[] getAllEmployees(){
    Employee[] emp_arr = new Employee[employees.size()]; 
  	return employees.toArray(emp_arr);
  }
}

// Petiscos
class Empregado {
	private String nome; 
  private String apelido; 
  private int codigo; 
	private double salario;
  
	public Empregado(String nome, String apelido, int codigo, double salario) { 
    this.nome = nome;
		this.apelido = apelido;
    this.codigo = codigo; 
    this.salario = salario;
}
  public String apelido() {
  	return apelido;
  }
  public String nome() { 
    return nome;
  }
  public int codigo() {
		return codigo;
  }
  public double salario() { 
    return salario;
  } 
}

class Registos {
    // Data elements
    private ArrayList<Empregado> empregados;
  
    public Registos() {
      empregados = new ArrayList<Empregado>();
    }
  
    public void insere(Empregado emp) {
      empregados.add(emp);
    }
  
    public void remove(int codigo) {
      for (Empregado e : empregados){
        if (e.codigo() == codigo){
            empregados.remove(e);
            return;
        }
      }
    }
  
    public boolean isEmpregado(int codigo) {
      for (Empregado e : empregados) {
        if (e.codigo() == codigo)
          return true;
      }
      return false;
    }
  
    public List<Empregado> listaDeEmpregados() {
      return empregados;
    }
  }