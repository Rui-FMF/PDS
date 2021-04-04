
public class Phone {
    private String processor;
    private double price;
    private int memory;
    private int camera;

    public Phone(String processor, double price, int memory, int camera) {
        this.processor = processor;
        this.price = price;
        this.memory = memory;
        this.camera = camera;
    }

    public String getProcessor() {
        return this.processor;
    }

    public double getPrice() {
        return this.price;
    }

    public int getMemory() {
        return this.memory;
    }

    public int getCamera() {
        return this.camera;
    }

}