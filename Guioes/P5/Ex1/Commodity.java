/*
*   This java file contains the Commodity interface.
    This interface is implemented in classes like Beverage and Meat.
*/
public interface Commodity {
    public Temperature getTemperature();    // Mandatory getTemperature() method.
    public State getState();                // Mandatory getState() method.
    public String toString();               // Mandatory toString() method.
}