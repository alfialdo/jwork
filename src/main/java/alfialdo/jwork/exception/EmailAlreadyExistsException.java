package alfialdo.jwork.exception;

import alfialdo.jwork.source.Jobseeker;

public class EmailAlreadyExistsException extends Exception{
    private String email;

    public EmailAlreadyExistsException(String email) {
        super("Email: ");
        this.email = email;
    }

    @Override
    public String getMessage() {
        return super.getMessage() + email + " already exists";
    }
}
