import java.util.Collection;

// Invoker
class RemoteControl<T> {
    private Command command;
    
    public void setCommand(Command command) {
        this.command = command;
    }
    public boolean execute(T element) {
        return command.execute(element);
    }

    public boolean undo(){
        return command.undo();
    }
}

//Command
interface Command<T> {
    public boolean execute(T element);
    public boolean undo();
}

// Concrete Command
class AddCommand<T> implements Command<T>{
    private Collection<T> col;
    private T lastElement;
    private boolean canUndo = false;

    public AddCommand(Collection<T> col) { 
        this.col = col; 
    }

    public boolean execute(T element) { 
        boolean res = this.col.add(element);
        if(res){
            this.lastElement = element;
            this.canUndo = true;
        }
        return res; 
    }

    public boolean undo(){
        if(canUndo){
            boolean res = this.col.remove(lastElement);
            this.canUndo = false;
            return res;
        }
        System.out.println("No action to undo");
        return false; 
    }
}

// Concrete Command
class RemoveCommand<T> implements Command<T>{
    private Collection<T> col;
    private T lastElement;
    private boolean canUndo = false;

    public RemoveCommand(Collection<T> col) { 
        this.col = col; 
    }

    public boolean execute(T element) { 
        boolean res = this.col.remove(element);
        if(res){
            this.lastElement = element;
            this.canUndo = true;
        }
        return res; 
    }

    public boolean undo(){
        if(canUndo){
            boolean res = this.col.add(lastElement);
            this.canUndo = false;
            return res;
        }
        System.out.println("No action to undo");
        return false; 
    }
}