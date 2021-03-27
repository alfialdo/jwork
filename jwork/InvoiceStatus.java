public enum InvoiceStatus {
    OnGoing,
    Finished,
    Cancelled;

    @Override
    public String toString() {
        switch(this) {
            case OnGoing : return "Ongoing";
            case Finished : return "Finished";
            case Cancelled : return "Cancelled";
            default : throw new IllegalArgumentException();
        }
    }
}
