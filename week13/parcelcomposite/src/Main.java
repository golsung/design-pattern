import java.util.ArrayList;
import java.util.List;

class Gold {
    private int weight;

    public Gold(int weight) {
        this.weight = weight;
    }

    public int price() {
        return this.weight/100*200;
    }
}

class Socks {
    private int weight;

    public Socks(int weight) {
        this.weight = weight;
    }

    public int price() {
        return this.weight/100*200;
    }
}
class Trousers {
    private int weight;

    public Trousers(int weight) {
        this.weight = weight;
    }

    public int price() {
        return this.weight/100*200;
    }
}

class Box {
    private List<Trousers> trousers = new ArrayList<>();
    private List<Socks> socks = new ArrayList<>();
    private List<Gold> golds = new ArrayList<>();
    private List<Box> boxes = new ArrayList<>();

    public int price() {
        int tPrice = 0;
        int sPrice = 0;
        int gPrice = 0;
        int bPrice = 0;

        for (Trousers t : trousers) {
            tPrice += t.price();
        }
        for (Socks s : socks) {
            sPrice += s.price();
        }
        for (Gold g : golds) {
            gPrice += g.price();
        }
        for (Box b : boxes) {
            bPrice += b.price();
        }

        return tPrice + sPrice + gPrice + bPrice;
    }
    public void addSocks(Socks s) { socks.add(s); }
    public void addTrousers(Trousers t) { trousers.add(t); }
    public void addGolds(Gold g) { golds.add(g); }
    public void addBox(Box b) { boxes.add(b); }

}

public class Main {
    public static void main(String[] args) {
        Box box1 = new Box();
        Socks s1 = new Socks(200);
        Socks s2 = new Socks(300);
        Trousers t1 = new Trousers(600);
        box1.addSocks(s1);
        box1.addSocks(s2);
        box1.addTrousers(t1);
        System.out.println(box1.price());

        Box box2 = new Box();
        Gold g1 = new Gold(800);
        box2.addBox(box1);
        box2.addGolds(g1);
        System.out.println(box2.price());

    }
}
