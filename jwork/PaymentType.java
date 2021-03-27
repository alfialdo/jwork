
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

// public enum PaymentType {
//     BankPayment("Bank Payment"),
//     EwalletPayment("E-Wallet Payment");

//     private String payment;

//     PaymentType (String payment) {
//         this.payment = payment;
//     }
   
//     @Override
//     public String toString() {
//         return this.payment.toString();
//     }
// }
