package alfialdo.jwork.exception;

public class BonusNotFoundException extends Exception{
    private int bonus_error;

    public BonusNotFoundException(int bonus_input) {
        super("Bonus ID: ");
        this.bonus_error = bonus_input;
    }

    @Override
    public String getMessage() {
        return super.getMessage() + bonus_error + " not found";
    }
}
