package AfterStrategy;
class PendingState implements IPaymentState {
    @Override
    public void handlePayment(ShoppingCart cart) {
        cart.processPayment();
    }
}
