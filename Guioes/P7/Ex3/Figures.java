class Quadrado extends Entity {
	private String name;
  
	public Quadrado(String name) {
		this.name = name;
	}
  
	public void draw() {
		System.out.println(indent.toString() + "Quadrado" + name);
	}
}

class Circulo extends Entity {
    private String name;
  
	public Circulo(String name) {
		this.name = name;
	}
  
	public void draw() {
		System.out.println(indent.toString() + "Circulo" + name);
	}
}

class Rectangulo extends Entity {
    private String name;
  
	public Rectangulo(String name) {
		this.name = name;
	}
  
	public void draw() {
		System.out.println(indent.toString() + "Rectangulo" + name);
	}
}