import java.util.ArrayList;

abstract class Observer {
  protected ArrayList<Product> productsInAuction;
  public abstract void update(Product p, boolean newBid);
}