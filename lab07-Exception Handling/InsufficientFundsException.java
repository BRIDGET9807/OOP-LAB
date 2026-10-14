public class InsufficientFundsException extends Exception {
    private final double shortfall;
    public InsufficientFundsException(String msg, double shortfall) {
        super(msg);
        this.shortfall = shortfall;
    }
    public double getShortfall() { return shortfall; }
}

