package AfterStrategy;
class SMSObserver implements IPaymentObserver {
    @Override
    public void update(String status) {
        System.out.println("SMS notification: " + status);
    }
}
