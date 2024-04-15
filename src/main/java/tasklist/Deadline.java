package tasklist;
public class Deadline extends Task {

    protected String by;

    public Deadline(String description, String by) {
        super(description);
        this.by = by;
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + by + ")";
    }

    public String getTaskStorageString(){
		String statusIndex="0";
		if (getStatusIcon().equals("X")){
			statusIndex="1";
		}
		return "D | "+statusIndex+" | "+super.getTaskStorageString()+" | "+ by;
	}
}
