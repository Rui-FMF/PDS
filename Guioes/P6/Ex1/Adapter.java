public class Adapter {
    private Registos r;
    private Database db;
  
    public Adapter(Registos r, Database db) {
      
      this.r = r;
      this.db = db;
    }
      
      // Manter registos e Empregado
      public void addEmployee(Empregado e) {
      
      if(this.isInCompany(e.codigo())){
        System.out.println("Employee already exists in the system!");
        return ;
      } 
      
      this.r.insere(e);
      
    }
  
    public void removeEmployee(int num){
      r.remove(num);
      db.deleteEmployee(num);
    }
      
      public void printAll() {
      
      for (Employee employee : this.db.getAllEmployees()) {
        
        System.out.printf("Name: %s | Employee Code: %d | Salary: %f\n", employee.getName(), employee.getEmpNum(), employee.getSalary());
        
      }
      
      for (Empregado empregado : this.r.listaDeEmpregados()) {
        
        System.out.printf("Name: %s %s | Employee Code: %d | Salary: %f\n", empregado.nome(), empregado.apelido(), empregado.codigo(), empregado.salario());
        
      }
      
    }
  
    public boolean isInCompany(int num){
    if(r.isEmpregado(num)){
      return true;
    } else{      
      for(Employee e : db.getAllEmployees()){
        if(e.getEmpNum() == num){
          return true;
        }
      }      
      return false;
    }
    }
  
  }
  