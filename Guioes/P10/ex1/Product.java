import java.util.ArrayList;
import java.util.List;

public class Product {
    private static int idCounter = 1;

    private int id;
    private String description;
    private double basePrice;
    private double price;
    private long AuctionTime = 0;
    private List<Observer> observers = new ArrayList<Observer>();
    private STATE state;

    public Product(String description, double basePrice) {
        this.id = idCounter++;
        this.description = description;
        this.basePrice = basePrice;
        this.price = basePrice;
        state = STATE.STOCK;

    }

    public void attach(Observer ob){
        observers.add(ob);
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
        notifyObservers(true);
    }

    public STATE getState(){
        return this.state;
    }

    public void setState(STATE state) {

        if(state == STATE.AUCTION){
            this.AuctionTime = System.nanoTime();
        }else{
            this.AuctionTime = System.nanoTime() - this.AuctionTime;
            if(state == STATE.STOCK){
                this.price = this.basePrice;
            }
        }
        this.state = state;
        notifyObservers(false);
    }

    private void notifyObservers(boolean newBid){
        for(Observer ob : observers){
            ob.update(this, newBid);
        }
    }

    @Override
    public String toString() {
        return id+": "+description;
    }

}