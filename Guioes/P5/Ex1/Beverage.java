/*
*   This java file contains the Beverage class and its methods.
    Since Beverage "is" a Commodity we implement the Commodity Interface.
*/
class Beverage implements Commodity {
    String name;            // Beverage Name
    State s = State.LIQUID; // Beverage State
    Temperature t;          // Beverage Temperature
    String flavour = null;  // Beverage Flavout -- If Beverage is FruitJuice it also has a flavour

    /*
     * -- Beverage Constructor --
        This constructor version is for the beverages that aren't FruitJuice.
        So, this doesn't have the 'Beverage Flavour' argument.
     */
    public Beverage(String name, Temperature t) {
        this.t = t;
        this.name = name;
    }

    /*
     * -- Beverage Constructor --
        This constructor version is for the FruitJuice beverage.
    */
    public Beverage(String name, Temperature t, String flavour) {
        this.t = t;
        this.name = name;
        this.flavour = flavour;
    }

    /*
     * -- toString Method --
        This method allows us to print all the atributes of a 'Beverage' object.
        This method is mandatory because we implemented the Commoditty interface in this class.
    */
    @Override
    public String toString() {
        if (flavour == null) { // Checks if 'flavour' has been initialized in the constructor.
            return (name + " [Temperature()=" + t + ", State()=" + s + "]"); // Doesn't print flavour - Used in Milk 
        } else { // If 'flavour' has a value
            return (name + " [fruit=" + flavour + " Temperature()=" + t + ", State()=" + s + "]"); // Prints the flavour
        }
    }

    /*
     * -- getTemperature() Method --
        This method is implemented because we implemented the 'Commodity' interface in this class. 
        So, this method is mandatory.
        Returns the temperature of the given object.
    */
    public Temperature getTemperature() {
        return this.t;
    }

    /*
     * -- getState() Method --
        This method is implemented because we implemented the 'Commodity' interface in this class. 
        So, this method is mandatory.
        Returns the state of the given object.
    */
    public State getState() {
        return this.s;
    }
}