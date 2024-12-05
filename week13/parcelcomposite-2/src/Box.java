import java.util.ArrayList;
import java.util.List;

public class Box extends ParcelItem{

    private List<ParcelItem> items = new ArrayList<>();

    public Box(int weight) {
        super(weight);
    }

    public int price() {
        int totalPrice = 0;


        for (ParcelItem item : items) {
            totalPrice += item.price();
        }
        return totalPrice;
    }

    public void addItems(ParcelItem item) { items.add(item); }

}
