package AfterStrategy;

class FailedState implements IPaymentState {
    @Override
    public void handlePayment(ShoppingCart cart) {
        cart.getPaymentNotifier().notifyAll("Payment already failed.");
    }
}
