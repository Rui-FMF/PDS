public class gammingPCBuilder implements PCBuilder {
	
	private PC pc;

	public gammingPCBuilder() {
		this.pc = new PC();
	}

	@Override
	public void buildCPU() {
		pc.setCPU("Intel Core i9-7980XE 18core 4.60 GHz");
	}

	@Override
	public void buildGPU() {
		pc.setGPU("RTX Titan 2x");
	}

	@Override
	public void buildRAM() {
		pc.setRAM(128);
	}

	@Override
	public void buildStorage() {
		pc.setStorage(6, "TB", "SSD");
	}

	@Override
	public void buildOS() {
		pc.setOS("Windows 10 Pro");
	}

	@Override
	public void buildPrice() {
		pc.setPrice(37000);
	}

	@Override
	public PC getPC() {
		return this.pc;
	}


}
