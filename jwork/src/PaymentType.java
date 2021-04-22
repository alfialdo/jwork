
/**
 * Enum untuk tipe payment
 * @author Muhammad Alfi A
 * @version Modul 4 - 30 March 2021
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
