package tasklist;

/**
 * Represents a generic task type called Task, which other task types are built on.
 * 
 * @param description The description of the task.
 * @param isDone Whether the task is completed.
 */
public class Task {
    protected String description;
    public boolean isDone;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }
    /**
     * Checks whether a task is marked done.
     * 
     * @returns String of either "X" or "" which indicates the done state.
     */
    public String getStatusIcon() {
        return (isDone ? "X" : " "); 
    }
    /**
     * Marks a task as done.
     */
    public void markDone(){
        this.isDone=true;
    }
    /**
     * Unmarks a task as done.
     */
    public void unmarkDone(){
        this.isDone=false;
    }
    
    /**
     * Returns the task in a specific format for printing.
     * For example, the list command which returns the current tasklist to the user.
     * @see commands.ListCommand
     */
    public String toString() {
        return ("["+ getStatusIcon() +"] " + description);
    }

    /**
     * Returns the task description String for printing.
     */
    public String getTaskStorageString(){
        return description;
    }
}
