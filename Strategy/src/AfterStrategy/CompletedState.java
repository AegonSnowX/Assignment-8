package AfterStrategy;
class CompletedState implements IPaymentState {
    @Override
    public void handlePayment(ShoppingCart cart) {
        cart.getPaymentNotifier().notifyAll("Payment already completed.");
    }
}
