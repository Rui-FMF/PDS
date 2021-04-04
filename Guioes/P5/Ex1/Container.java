/*
*   This java file contains the Container abstract class.
    This abstract class is used in classes like ContainerType.
*/
public abstract class Container {
    protected Commodity c; 

    /*
    * -- placeCommodity() Method -- 
        Places the Commodity in the container.
    */
    public boolean placeCommodity(Commodity c) {
        this.c = c;
        return true;
    }

}