package alfialdo.jwork;

public class RecruiterNotFoundException extends Exception {
    private int recruiter_error;

    public RecruiterNotFoundException(int recruiter_input) {
        super("Recruiter ID: ");
        this.recruiter_error = recruiter_input;
    }

    @Override
    public String getMessage() {
        return super.getMessage() + recruiter_error + " not found";
    }
}
