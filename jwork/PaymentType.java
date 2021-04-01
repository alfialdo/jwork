
public enum PaymentType {
    BankPayment("Bank Payment"),
    EwalletPayment("E-Wallet Payment");

    private String payment;

    PaymentType (String payment) {
        this.payment = payment;
    }
   
    @Override
    public String toString() {
        return this.payment.toString();
    }
}
