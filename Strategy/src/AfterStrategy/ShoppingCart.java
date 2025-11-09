package AfterStrategy;

class ShoppingCart {
    public IPaymentStrategy paymentStrategy;
    private PaymentNotifier paymentNotifier;
    private IPaymentState state;

    ShoppingCart() {
        this.paymentNotifier = new PaymentNotifier();
        this.state = new PendingState();
    }

    void setPaymentStrategy(IPaymentStrategy strategy) {
        this.paymentStrategy = strategy;
    }

    public void checkout(int amount) {
        if (paymentStrategy == null) {
            paymentNotifier.notifyAll("No payment strategy set.");
            return;
        }
        state.handlePayment(this);
        // In this simple flow, processPayment triggers the strategy and notifier.
        // State transitions can be handled inside processPayment or based on results.
    }

    public void setState(IPaymentState state) {
        this.state = state;
    }

    public void processPayment() {
        try {
            // Example: fixed amount; real flow would pass actual total
            paymentStrategy.pay(100);
            paymentNotifier.notifyAll("Payment completed successfully.");
            setState(new CompletedState());
        } catch (Exception e) {
            paymentNotifier.notifyAll("Payment failed: " + e.getMessage());
            setState(new FailedState());
        }
    }

    // Helper accessors for state objects to reach notifier if needed
    public PaymentNotifier getPaymentNotifier() {
        return paymentNotifier;
    }
}
