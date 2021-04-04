/*
*   This java file contains the BeverageFactory class and its methods.
    MeatFactory implementes the 'Factory Desgin Pattern' allowing us to check if the
        object we're trying to create is valid. Thus, if the object has valid attributes only then it's initialized.
    This saves memory because invalid objects are never created. 
*/
public class MeatFactory {
    /*
    * -- createMeat Method -- 
        Method used to validate arguments and create 'Meat' objects.
    */
    public static Meat createMeat(Temperature t) {
        if (t == Temperature.COLD) {
            return new Meat("Tuna", t);
        } else if (t == Temperature.WARM) {
            return new Meat("Pork", t);
        } else {
            return null;
        }
    }
}