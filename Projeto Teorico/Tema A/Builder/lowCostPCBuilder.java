public class lowCostPCBuilder implements PCBuilder {
	
	private PC pc;

	public lowCostPCBuilder() {
		this.pc = new PC();
	}

	@Override
	public void buildCPU() {
		pc.setCPU("Intel Core 2 Duo 1.8Ghz");
	}

	@Override
	public void buildGPU() {
		pc.setGPU("128MB ATI Radeon X1300 ");
	}

	@Override
	public void buildRAM() {
		pc.setRAM(2);
	}

	@Override
	public void buildStorage() {
		pc.setStorage(160, "GB", "HDD");
	}

	@Override
	public void buildOS() {
		pc.setOS("Windows XP");
	}

	@Override
	public void buildPrice() {
		pc.setPrice(100);
	}

	@Override
	public PC getPC() {
		return this.pc;
	}


}
