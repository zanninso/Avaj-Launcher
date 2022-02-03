import java.util.ArrayList;
import java.util.List;

public class Tower {
    private List<Flyable> observers = new ArrayList<>();
    private List<Flyable> observers_to_clear = new ArrayList<>();

    public void register(Flyable flyable) {
        observers.add(flyable);
        System.out.println("Tower says: " + flyable.getAid() + " registered to weather tower.");
    }

    public void unregister(Flyable flyable) {
        observers_to_clear.add(flyable);
        System.out.println(flyable.getAid() + " landing.");
        System.out.println("Tower says: " + flyable.getAid() + " unregistered from weather tower.");
        System.out.println(flyable.getAid() + " " + flyable.getCoordinates());
    }

    protected void conditionsChanged() throws NegativeCoordinatesException, OutOfRangeException {
        for (Flyable observer : observers) {
            observer.updateConditions();
        }
        for (Flyable observer : observers_to_clear) {
            observers.remove(observer);
        }
        observers_to_clear.clear();
    }

    public int getObserversCount() {
        return observers.size();
    }
}
