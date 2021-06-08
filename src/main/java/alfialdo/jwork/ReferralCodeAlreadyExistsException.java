package alfialdo.jwork;

public class ReferralCodeAlreadyExistsException extends Exception{
    private Bonus referral_error;

    public ReferralCodeAlreadyExistsException(Bonus referral_input) {
        super("Referral ID: ");
        this.referral_error = referral_input;
    }

    @Override
    public String getMessage() {
        return super.getMessage() + referral_error.getReferralCode() + " already exists";
    }
}
