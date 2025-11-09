package AfterStrategy;

// Concrete Strategy 2
class PayPalPayment implements IPaymentStrategy {
    private String email;

    PayPalPayment(String email) {
        this.email = email;
    }

    public void pay(int amount) {

        System.out.println("Paid " + amount + " using PayPal (Email: " + email + ")");
    }
}