package AfterStrategy;

import java.util.ArrayList;
import java.util.List;

class PaymentNotifier {
    private List<IPaymentObserver> observers = new ArrayList<>();

    public void addObserver(IPaymentObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(IPaymentObserver observer) {
        observers.remove(observer);
    }

    public void notifyAll(String status) {
        for (IPaymentObserver obs : observers) {
            obs.update(status);
        }
    }
}
