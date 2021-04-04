/*
* Rui Filipe, LEI
* Lucas Sousa, LEI
*/
import java.util.ArrayList;
import java.util.Collections;

public class Street {
    private ArrayList<Family> street; // ArrayList of families
    private int first_door = 1000;
    private int last_door = -1;
    private int biggest_name = 0;

    public Street() {
        this.street = new ArrayList<Family>();
    }

    public void addPerson(Person newPerson) {
        String personRange = newPerson.getRange();

        // checks if person already exists on the street
        if (isMember(newPerson)) {
            System.out.println(newPerson.getName() + " can't be added to street, name already taken!");
            return;
        }

        // Update biggest name
        if (newPerson.getName().length() > biggest_name) {
            biggest_name = newPerson.getName().length();
        }

        // iterating through all the families in the street
        for (Family family : street) {
            /*
             * if family range equals the range of the person to be added -> the person is
             * added to the family
             */
            if (family.getRange().equals(personRange)) {
                family.addMember(newPerson);
                return; // person is added and function 'ends'
            }
        }

        /*
         * if the person doesn't have a family in the street we need to create a new
         * family for the person
         */

        Family newFamily = new Family(personRange); // creates a new family with the newPerson's age
        newFamily.addMember(newPerson); // adds person to the family
        street.add(newFamily); // adds the new family with the new person to the street

        // Updates First and Last Door
        if (newFamily.getFirstDoor() < first_door) {
            first_door = newFamily.getFirstDoor();
        }
        if (newFamily.getLastDoor() > last_door) {
            last_door = newFamily.getLastDoor();
        }

    }

    //method used to sort street from family with most occupied door to the one with least occupied doors
    public void sort() {
        Collections.sort(street, Collections.reverseOrder());
    }

    public void printStreet() {
        if(street.isEmpty()){
            System.out.println("Street is Empty!");
            return;
        }
        int counter = 1;
        System.out.printf("%-10s %-" + (biggest_name + 1) + "s", "FAMILY", "NAME");
        for (int i = first_door; i <= last_door; i++) {
            System.out.printf("%-5d", i);
        }
        System.out.println();
        for (Family f : street) {
            for (Person p : f.getMembers()) {
                System.out.printf("%-10s %-" + (biggest_name + 1) + "s", counter, p.getName());
                for (int i = first_door; i <= last_door; i++) {
                    if (i >= f.getFirstDoor() && i <= f.getLastDoor()) {
                        System.out.printf("%-5s", "X");
                    } else {
                        System.out.printf("%-5s", "  ");
                    }
                }
                System.out.println();
            }
            counter++;
        }
    }

    /*
     * Method used in 'REMOVE' case (in main function - Main class)
     */
    /*
     * This iterates through the street until it finds the person that's supposed to
     * be removed. When it's found, we call the 'removeMember' method to remove the
     * person from the family, if in turn a family is left empty, it's removed from the street.
     */
    public void removePerson(String name) {
        for (Family family : street) {
            for (Person person : family.getMembers()) {
                if (person.getName().equals(name)) {
                    family.removeMember(person);
                    if(family.getMembers().isEmpty()){
                        street.remove(family);
                    }
                    return;
                }
            }
        }
        System.out.println(name + " is not a person in the street!");
        return;
    }

    /*
     * Method used in 'addPerson'
     */
    /*
     * This checks if a certain person belongs to the street or not
     */
    public boolean isMember(Person p) {
        for (Family family : street) {
            for (Person person : family.getMembers()) {
                if (person.getName().equals(p.getName())) {
                    return true;
                }
            }
        }
        return false;
    }

    /*
     * Method used in 'LOOKUP' case (in main function - Main class)
     */
    /*
     * This prints the family of given person (name) if the person exists on the street
     */
    public void lookup(String name){
        for (Family family : street) {
            for (Person person : family.getMembers()) {
                if (person.getName().equals(name)) {
                    System.out.println(family);
                    return;
                }
            }
        }
        System.out.println(name + " is not a person in the street!");
        return;
    }

    /*
     * Method used in 'LIST' case (in main function - Main class)
     */
    /*
     * This prints every person of the street in alphabetical order
     */
    public void list(){
        ArrayList<String> people = new ArrayList<String>();
        for (Family family : street) {
            for (Person person : family.getMembers()) {
                people.add(person.toString());
            }
        }
        Collections.sort(people);
        for(String s : people){
            System.out.println(s);
        }

    }


    /*
     * Method used in 'CLEAR' case (in main function - Main class)
     */
    /*
     * This empties the array of families and sets variables to initial values
     */
    public void reset(){
        this.street.clear();
        first_door = 1000;
        last_door = -1;
        biggest_name = 0;
    }
}