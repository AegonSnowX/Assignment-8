package BeforeStrategy;

// Before applying Strategy Design Pattern
class ShoppingCart {
    private String paymentMethod;
    private String cardNumber;
    private String name;
    private String email;

    // Method to set the payment method
    void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    // Method to set Credit Card details
    void setCreditCardDetails(String cardNumber, String name) {
        this.cardNumber = cardNumber;
        this.name = name;
    }

    // Method to set PayPal details
    void setPayPalDetails(String email) {
        this.email = email;
    }

    // Checkout process
    void checkout(int amount) {
        if (paymentMethod == null) {
            System.out.println("Please select a payment method first.");
            return;
        }

        switch (paymentMethod) {
            case "CreditCard":
                if (cardNumber == null || name == null) {
                    System.out.println("Please provide credit card details.");
                } else {
                    System.out.println("Paid " + amount + " using Credit Card (Card Number: " + cardNumber + ", Name: " + name + ")");
                }
                break;

            case "PayPal":
                if (email == null) {
                    System.out.println("Please provide PayPal email.");
                } else {
                    System.out.println("Paid " + amount + " using PayPal (Email: " + email + ")");
                }
                break;

        }
    }
}

