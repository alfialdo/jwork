public enum PaymentType {
    BankPayment,
    EwalletPayment;

    @Override
    public String toString() {
        switch(this) {
            case BankPayment : return "Bank Payment";
            case EwalletPayment : return "E-Wallet Payment";
            default: throw new IllegalArgumentException();
        }
    }
   
}
