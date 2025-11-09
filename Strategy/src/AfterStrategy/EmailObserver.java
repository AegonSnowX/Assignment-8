package AfterStrategy;

class EmailObserver implements IPaymentObserver {
    @Override
    public void update(String status) {
        System.out.println("Email notification: " + status);
    }
}
