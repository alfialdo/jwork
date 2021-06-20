package alfialdo.jwork.source;

/**
 * Enum untuk tipe payment
 * @author Muhammad Alfi A
 * @version Final Project - 20 June 2021
 */
public enum PaymentType {
    BankPayment("Bank Payment"),
    EwalletPayment("E-Wallet Payment");

    private String payment;

    PaymentType (String payment) {
        this.payment = payment;
    }
   
    @Override
    public String toString() {
        return this.payment;
    }
}
