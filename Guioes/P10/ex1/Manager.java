import java.util.ArrayList;

public class Manager extends Observer {
    private String name;

    protected ArrayList<Product> soldProducts;
    protected ArrayList<Product> ProductsInStock;

    Manager(String name){
        this.name = name;

        this.productsInAuction = new ArrayList<Product>();
        this.soldProducts = new ArrayList<Product>();
        this.ProductsInStock = new ArrayList<Product>();
    }

    public void registerProduct(Product p){
        switch(p.getState()){
            case AUCTION:
                this.productsInAuction.add(p);
                break;
            case STOCK:
                this.ProductsInStock.add(p);
                break;
            case SALES:
                this.soldProducts.add(p);
                break;
        }
        p.attach(this);
    }

    public void update(Product p, boolean newBid){
        if(newBid){
            System.out.printf("Manager %s : The product '%s' has a new bid, current Price is: %f\n",this.name,p.toString(),p.getPrice());
        } else{
            switch(p.getState()){
                case AUCTION:
                    this.ProductsInStock.remove(p);
                    this.productsInAuction.add(p);
                    break;
                case STOCK:
                    this.productsInAuction.remove(p);
                    this.ProductsInStock.add(p);
                    break;
                case SALES:
                    this.productsInAuction.remove(p);
                    this.soldProducts.add(p);
                    System.out.printf("Manager %s : The product '%s' has been sold for: %f\n",this.name,p.toString(),p.getPrice());
                    break;
            }
        }
    }

}