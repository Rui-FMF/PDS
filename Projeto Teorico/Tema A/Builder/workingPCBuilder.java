public class workingPCBuilder implements PCBuilder {
	
	private PC pc;

	public workingPCBuilder() {
		this.pc = new PC();
	}

	@Override
	public void buildCPU() {
		pc.setCPU("Intel Core i5-9400 Hexa 2.90 GHz");
	}

	@Override
	public void buildGPU() {
		pc.setGPU("AMD Radeon RX 580");
	}

	@Override
	public void buildRAM() {
		pc.setRAM(12);
	}

	@Override
	public void buildStorage() {
		pc.setStorage(256, "GB", "SSD");
	}

	@Override
	public void buildOS() {
		pc.setOS("Ubuntu 18");
	}

	@Override
	public void buildPrice() {
		pc.setPrice(1000);
	}

	@Override
	public PC getPC() {
		return this.pc;
	}


}
