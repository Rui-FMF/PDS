/*
* Rui Filipe, LEI
* Lucas Sousa, LEI
*/
public class Person {
    private String range; // Range of ocupation (ex: "10-17")
    private String name; // Name of the person

    public static Person Create(String input) {
        // converts "x1-x2 Name" to array: ["x1-x2", "Name"]
        String[] info = input.split(" ");
        String range = info[0];

        String name = info[1];
        if (!checkName(name)) {
            return null;
        }
        return new Person(name, range);
    }

    // constructor that only gets called if the name checks all the parameters
    public Person(String name, String range) {
        this.name = name;
        this.range = range;
    }

    public static boolean checkName(String name) {
        String symbols = "._@";

        for (int i = 0; i < name.length(); i++) {
            // checks if name only as letters, numbers and the specified symbols
            if (!(Character.isDigit(name.charAt(i)) || Character.isLetter(name.charAt(i))
                    || symbols.contains(String.valueOf(name.charAt(i))))) {
                return false;
            }
        }

        // checks if 1st char is letter
        if (!Character.isLetter(name.charAt(0))) {
            return false;
        }

        // checks if last char is symbol
        if (!(Character.isLetter(name.charAt(name.length() - 1))
                || Character.isDigit(name.charAt(name.length() - 1)))) {
            return false;
        }

        // checks if 3 <= length <= 30
        if (name.length() < 3 || name.length() > 30) {
            return false;
        }

        return true;
    }

    public String getName() {
        return name;
    }

    public String getRange() {
        return range;
    }

    public String toString() {
        return (name + ": " + range);
    }
}