package tasklist;

/**
 * Represents a specific task of type Event.
 * 
 * @see Task
 */
public class Event extends Task {

    protected String startsAt;
    protected String endsAt;

    public Event(String description, String startsAt, String endsAt) {
        super(description);
        this.startsAt=startsAt;
        this.endsAt=endsAt;
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (from: " + startsAt + " to: " + endsAt + ")";
    }

    public String getTaskStorageString(){
		String statusIndex="0";
		if (getStatusIcon().equals("X")){
			statusIndex="1";
		}
		return "E | "+statusIndex+" | "+super.getTaskStorageString()+" | "+ startsAt + endsAt;
	}
}
