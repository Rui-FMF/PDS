/*
*   This java file contains the BeverageFactory class and its methods.
    BeverageFactory implementes the 'Factory Desgin Pattern' allowing us to check if the
        object we're trying to create is valid. Thus, if the object has valid attributes only then it's initialized.
    This saves memory because invalid objects are never created. 
*/
public class BeverageFactory {
    /*
    * -- createBeverage Method -- 
        Method used to validate arguments and create 'Beverage' objects.
    */
    public static Beverage createBeverage(Temperature t) {
        if (t == Temperature.COLD) {        
            return new Beverage("FruitJuice", t, "Orange");
        } else if (t == Temperature.WARM) {
            return new Beverage("Milk", t);
        } else {
            return null;
        }
    }

}