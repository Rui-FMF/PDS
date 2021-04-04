public class PC {

	private String CPU;
	private String GPU;
	private String RAM;
	private String Storage;
	private String OS;
	private String price;
	
	public String getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price+" $";
	}

	public String getCPU() {
		return CPU;
	}
	
	public void setCPU(String CPU) {
		this.CPU = CPU;
	}
	
	public String getGPU() {
		return GPU;
	}
	
	public void setGPU(String GPU) {
		this.GPU = GPU;
	}
	
	public String getRAM() {
		return RAM;
	}
	
	public void setRAM(int RAM) {
		this.RAM = RAM+" GB";
	}
	
	public String getStorage() {
		return Storage;
	}
	
	public void setStorage(int ammount, String unit, String type) {
		if(!(unit=="GB" || unit=="TB")) {
			System.err.println("Unit of Storage can't be "+unit);
			System.exit(0);
		}
		if(!(type=="HDD" || type=="SSD")) {
			System.err.println("Type of Storage can't be "+type);
			System.exit(0);
		}
		this.Storage = ammount+" "+unit+" "+type;
	}
	
	public String getOS() {
		return OS;
	}
	
	public void setOS(String OS) {
		this.OS = OS;
	}
	
	@Override
	public String toString() {
		return " PC:\n\tCPU -> "+CPU+"\n\tGPU -> "+GPU+"\n\tRAM -> "+RAM+"\n\tStorage -> "+Storage+"\n\tOS -> "+OS+"\n\tPrice -> "+price;
	}

}
