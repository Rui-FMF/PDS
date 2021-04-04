/*
*   This java file contains the Meat class and its methods.
    Since Meat "is" a Commodity we implement the Commodity Interface.
*/
class Meat implements Commodity {
    String name;            // Meat name
    State s = State.SOLID;  // Meat state
    Temperature t;          // Meat temperature

    /*
     * -- Meat Constructor --
        This creates a 'Meat' object
     */
    public Meat(String name, Temperature t) {
        this.t = t;
        this.name = name;
    }

     /*
     * -- toString Method --
        This method allows us to print all the atributes of a 'Meat' object.
        This method is mandatory because we implemented the Commoditty interface in this class.
    */
    @Override
    public String toString() {
        return (name + " [Temperature()=" + t + ", State()=" + s + "]");

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