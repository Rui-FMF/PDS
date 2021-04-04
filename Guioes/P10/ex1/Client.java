import java.util.ArrayList;

public class Client extends Observer {
    private String name;

    Client(String name){
        this.name = name;
        this.productsInAuction = new ArrayList<Product>();
    }

    public void bid(Product p, double ammount){
        if(!this.productsInAuction.contains(p)){
            if(p.getState()==STATE.AUCTION){
                p.attach(this);
                this.productsInAuction.add(p);
            } else{
                System.out.println("Item is not for auction!");
                return;
            }
        }

        if(ammount < p.getPrice()){
            System.out.println("bid needs to be bigger than current price! (Price:"+p.getPrice()+")");
            return;
        }
        p.setPrice(ammount);
    }

    public void update(Product p, boolean newBid){
        if(newBid){
            System.out.printf("Client %s : The product '%s' has a new bid, current Price is: %f\n",this.name,p.toString(),p.getPrice());
        } else{
            this.productsInAuction.remove(p);
            if(p.getState()==STATE.SALES){
                System.out.printf("Client %s : The product '%s' has been sold for: %f\n",this.name,p.toString(),p.getPrice());
            } else if(p.getState()==STATE.STOCK){
                System.out.printf("Client %s : The product '%s' is no longer in auction\n",this.name,p.toString());
            }
        }
    }
}