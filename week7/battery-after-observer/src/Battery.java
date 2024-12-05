import java.util.ArrayList;
import java.util.List;

public class Battery extends Subject {
    private int level = 100;


    public void consume(int amount) {
        level -= amount;
        notifyObservers();
    }


    public int getLevel() {

        return level;
    }
}
