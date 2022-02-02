import java.util.ArrayList;
import java.util.List;

public class Tower {
    private List<Flyable> observers = new ArrayList<>();

    public void register(Flyable flyable) {
        observers.add(flyable);
        System.out.println("Tower says: " + flyable.getAid() + " registered to weather tower.");
    }

    public void unregister(Flyable flyable) {
        observers.remove(flyable);
        System.out.println(flyable.getAid() + " landing.");
        System.out.println("Tower says: " + flyable.getAid() + " unregistered from weather tower.");
    }

    protected void conditionsChanged() {
        for (Flyable observer : observers) {
            observer.updateConditions();
        }
    }

    public int getObserversCount() {
        return observers.size();
    }
}
