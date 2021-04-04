/*
* Rui Filipe, LEI
* Lucas Sousa, LEI
*/
import java.util.ArrayList;

public class Family implements Comparable<Family> {
    private ArrayList<Person> members = new ArrayList<Person>();    //Array of Person, stores familly members
    private String range;       //range in String format: x1-x2
    private int range_val;      //Amount of doors occupied by family (last door - first door)
    private int first_door;     //First door occupied by family
    private int last_door;      //Last door occupied by family

    //CONSTRUCTOR
    public Family(String range) {
        this.range = range;
        String vals[] = range.split("-");
        this.first_door = Integer.parseInt(vals[0]);
        this.last_door = Integer.parseInt(vals[1]);
        this.range_val = last_door - first_door;
    }

    //method used to compare families with one another, comparison is done taking
    //in account the amount of doors occupied (range_val)
    public int compareTo(Family f) {
        return this.range_val - f.range_val;
    }

    public void addMember(Person p) {
        members.add(p);
    }

    public String getRange() {
        return range;
    }

    public void removeMember(Person p) {
        members.remove(p);
    }

    public ArrayList<Person> getMembers() {
        return members;
    }

    public int getFirstDoor() {
        return first_door;
    }

    public int getLastDoor() {
        return last_door;
    }

    /*
     * Method used in 'LOOKUP' case (in main function - Main class)
     */
    /*
     * prints every member of the family
     */

    public String toString() {
        String str = range + ": ";
        for (Person p : members) {
            str += p.getName() + " ";
        }
        return str;
    }

}