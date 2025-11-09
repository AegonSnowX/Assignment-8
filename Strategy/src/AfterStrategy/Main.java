
package AfterStrategy;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ShoppingCart cart = new ShoppingCart();

        // Register observers
        cart.getPaymentNotifier().addObserver(new EmailObserver());
        cart.getPaymentNotifier().addObserver(new SMSObserver());

        // Get amount
        System.out.print("Enter amount (int): ");
        int amount = Integer.parseInt(sc.nextLine().trim());
        cart.workingAmount = amount;

        // Choose payment method
        System.out.println("Choose payment method:");
        System.out.println("1) Credit Card");
        System.out.println("2) PayPal");
        System.out.print("Selection: ");
        String sel = sc.nextLine().trim();

        switch (sel) {
            case "1": {
                System.out.print("Enter card number: ");
                String number = sc.nextLine().trim();
                System.out.print("Enter cardholder name: ");
                String name = sc.nextLine().trim();
                cart.setPaymentStrategy(new CreditCardPayment(number, name));
                break;
            }
            case "2": {
                System.out.print("Enter PayPal email: ");
                String email = sc.nextLine().trim();
                cart.setPaymentStrategy(new PayPalPayment(email));
                break;
            }
            default:
                System.out.println("Invalid selection; exiting.");
                sc.close();
                return;
        }

        // Kick off the workflow
        cart.checkout(amount);

        // Demo: attempt to re-run after completion to show state guarding
        System.out.println("Attempting to process again to show state behavior...");
        cart.checkout(amount);

        sc.close();
    }
}
