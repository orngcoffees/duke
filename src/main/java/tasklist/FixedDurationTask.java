package tasklist;

public class FixedDurationTask extends Task {

    protected String duration;

    public FixedDurationTask(String description, String duration) {
        super(description);
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "[F]" + super.toString() + " (needs " + duration + ")";
    }

    public String getTaskStorageString(){
		String statusIndex="0";
		if (getStatusIcon().equals("X")){
			statusIndex="1";
		}
		return "F | "+statusIndex+" | "+super.getTaskStorageString()+" | "+ duration;
	}
}
