public class PCDirector {
	
	private PCBuilder builder;

	public PCDirector(PCBuilder builder) {
		this.builder = builder;
	}
	
	public PC getPC() {
		return this.builder.getPC();
	}
	
	public void setBuilder(PCBuilder builder) {
		this.builder = builder;
	}

	public void makePC() {
		this.builder.buildCPU();
		this.builder.buildGPU();
		this.builder.buildOS();
		this.builder.buildPrice();
		this.builder.buildRAM();
		this.builder.buildStorage();
	}

}
