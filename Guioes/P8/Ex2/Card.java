public class Card {
    private String name;
    private int ID;

    private static int currentID = 0;

    public Card(String name) {
        this.name = name;
        this.ID = currentID;
        currentID++;
    }

    public String getCard() {
        return "Name: " + this.name + "\nID #: " + this.ID;
    }
}