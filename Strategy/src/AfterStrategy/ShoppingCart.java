
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
            paymentNotifier.notifyAll("Error: no payment strategy selected");
            return;
        }
        paymentNotifier.notifyAll("Transition: PENDING -> processing");
        state.handlePayment(this);
    }

    public void setState(IPaymentState state) {
        this.state = state;
    }

    public void processPayment() {
        try {
            paymentNotifier.notifyAll("Processing payment...");
            paymentStrategy.pay(workingAmount);
            paymentNotifier.notifyAll("Transition: processing -> COMPLETED");
            setState(new CompletedState());
            paymentNotifier.notifyAll("Payment completed successfully");
        } catch (RuntimeException ex) {
            paymentNotifier.notifyAll("Transition: processing -> FAILED");
            setState(new FailedState());
            paymentNotifier.notifyAll("Payment failed: " + ex.getMessage());
        }
    }

    // injected by Main to carry the user-entered amount during the flow
    int workingAmount = 0;

    public PaymentNotifier getPaymentNotifier() {
        return paymentNotifier;
    }
}
