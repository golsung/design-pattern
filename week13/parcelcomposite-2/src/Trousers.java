public class Trousers extends ParcelItem{
    public Trousers(int weight) {
        super(weight);
    }

    public int price() {
        return this.weight/100*200;
    }
}
