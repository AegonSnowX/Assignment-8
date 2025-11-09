package AfterStrategy;

public class Main {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        // Attach observers
        cart.getPaymentNotifier().addObserver(new EmailObserver());
        cart.getPaymentNotifier().addObserver(new SMSObserver());

        // Choose strategy
        cart.setPaymentStrategy(new CreditCardPayment("1234567890123456", "Alex Dev"));

        // Checkout
        cart.checkout(100);

        // Switch strategy and pay again
        cart.setPaymentStrategy(new PayPalPayment("alex@example.com"));
        cart.setState(new PendingState());
        cart.checkout(200);
    }
}
