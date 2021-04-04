public class Main {
    public static void main(String[] args) {
        
        Product p1 = new Product("Fossil", 340.0);
        Product p2 = new Product("Mona Lisa", 20000.0);
        Product p3 = new Product("Ford Fiesta", 10.0);
        Product p4 = new Product("Gold Bar", 3500.0);

        Client c1 = new Client("The Rock");
        Client c2 = new Client("Da Vinci");
        Client c3 = new Client("Quim Barreiros");

        Manager mg = new Manager("Rick Harrison");
        mg.registerProduct(p1);
        mg.registerProduct(p2);
        mg.registerProduct(p3);
        mg.registerProduct(p4);

        p1.setState(STATE.AUCTION);
        p3.setState(STATE.AUCTION);

        c1.bid(p1, 500.4);
        System.out.println("");
        c1.bid(p3, 20);
        System.out.println("");

        p4.setState(STATE.AUCTION);

        c2.bid(p1,520.6);
        System.out.println("");

        c1.bid(p1,600);
        System.out.println("");

        c3.bid(p4,4242.42);
        System.out.println("");

        p1.setState(STATE.SALES);
        c2.bid(p1,10);

    }
}