/*
*   This java file contains the Conatiner class and its methods.
    MeatFactory implementes the 'Factory Desgin Pattern' allowing us to check if the
        object we're trying to create is valid. Thus, if the object has valid attributes only then it's initialized.
    This saves memory because invalid objects are never created. 
*/
public class ContainerFactory {
    public static Container createContainerFor(Commodity c) {
        Temperature t = c.getTemperature(); // Gets the temperature of the given commodity
        State s = c.getState();             // Gets the state of the given commodity
        
        if (s == State.LIQUID) {                                    // if state is LIQUID
            if (t == Temperature.COLD) {                            // if temperature is COLD
                return new ContainerType(c,"PlasticBottle", s, t);  // creates adequate container for type of commodity

            } else if (t == Temperature.WARM) {                     // if temperature is WARM
                return new ContainerType(c,"TermicBottle", s, t);   // creates adequate container for type of commodity

            } else {                                                // if temperature is invalid
                return null;                                        // creates 'null' object 
            }

        } else if (s == State.SOLID) {                              // if state is SOLID
            if (t == Temperature.COLD) {                            // if temperature is COLD
                return new ContainerType(c,"PlasticBag", s, t);     // creates adequate container for type of commodity

            } else if (t == Temperature.WARM) {                     // if temeprature is WARM
                return new ContainerType(c,"Tupperware", s, t);     // creates adequate container for type of commodity

            } else {                                                // if temperature is invalid
                return null;                                        // creates 'null' object 
            }

        } else {                                                    // if state is invalid
            return null;                                            // creates 'null' object 
        }
    }
}