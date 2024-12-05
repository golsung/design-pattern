public class Shirts {
    private int weight;

    public Shirts(int weight) {
        this.weight = weight;
    }

    public int price() {
        return this.weight/100*200;
    }
}
