/*
*   This java file contains the ContainerType class.
    This class extends the Container abstract class.
*/
public class ContainerType extends Container {
    String type;        // Type of Container
    State s;            // State of the commodity the given container can store
    Temperature t;      // Temperature of the commodity the given container can store
    Commodity c;        // Commodity that the container is going to store

    /*
    *   -- ContainerType Constructor -- 
        This is the contructor of the Container 
    */
    public ContainerType(Commodity c, String type, State s, Temperature t) {
        this.type = type;
        this.s = s;
        this.t = t;
        this.c = c;
    }
    /*
    * -- toString() Method -- 
        This is the contructor of the Container 
    */
    @Override
    public String toString() {
        return (type + "[commodity=" + c.toString() + "]");
    }
}