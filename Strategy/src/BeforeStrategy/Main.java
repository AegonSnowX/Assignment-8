package BeforeStrategy;


 class Main {
    public static void main(String[] args) {

        ShoppingCart cart = new ShoppingCart();

        // Using Credit Card payment
        cart.setPaymentMethod("CreditCard");
        cart.setCreditCardDetails("1234-5678-9012-3456", "John Doe");
        cart.checkout(100);

        System.out.println();

        // Using PayPal payment
        cart.setPaymentMethod("PayPal");
        cart.setPayPalDetails("john.doe@example.com");
        cart.checkout(50);
    }
}