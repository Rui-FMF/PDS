import java.util.ArrayList;
import java.util.List;

class Bloco extends Entity {
    private List<Entity> children = new ArrayList<>();
    private String name;
  
    public Bloco(String name) {
  	    this.name = name;
    }
  
    public void add(Entity c) {
  		children.add(c);
    }
  
  public void draw() {
    System.out.println(indent.toString() + "Window" + name);
    indent.append("   ");
    
    for (int i = 0; i < children.size(); i++){
        children.get(i).draw();
    }
    indent.setLength(indent.length() - 3);
    
  }
}