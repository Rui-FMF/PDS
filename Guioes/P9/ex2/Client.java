import java.util.ArrayList;
import java.util.Collection;

public class Client {
    public static void main(String[] args) {
        RemoteControl control = new RemoteControl();
        Collection list = new ArrayList<>();
        Command add = new AddCommand(list);
        Command remove = new RemoveCommand(list);
        //switch on
        control.setCommand(add);
        control.execute("Manuel");
        control.execute("Maria");
        control.execute("Alberto");
        control.execute("Roberto");
        System.out.println(list);
        control.undo();
        System.out.println(list);
        //switch off
        control.setCommand(remove);
        control.execute("Maria");
        control.execute("Alberto");
        control.undo();
        System.out.println(list);
    }
}