package tasklist;

/**
 * Represents a specific task of type Todo.
 * 
 * @see Task
 */
public class Todo extends Task {

    protected String by;

    public Todo(String description) {
        super(description);
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }

    public String getTaskStorageString(){
		String statusIndex="0";
		if (getStatusIcon().equals("X")){
			statusIndex="1";
		}
		return "T | "+statusIndex+" | "+super.getTaskStorageString()+"";
	}
}
