package AfterStrategy;

// Concrete Strategy 1
class CreditCardPayment implements IPaymentStrategy {
    private String cardNumber;
    private String name;

    CreditCardPayment(String cardNumber, String name) {
        this.cardNumber = cardNumber;
        this.name = name;
    }

    public void pay(int amount) {
        System.out.println("Paid " + amount + " using Credit Card (Card Number: " + cardNumber + ", Name: " + name + ")");
    }
}