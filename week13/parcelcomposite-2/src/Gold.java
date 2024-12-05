public class Gold extends ParcelItem{
    public Gold(int weight) {
        super(weight);
    }

    public int price() {
        return this.weight/100*2000;
    }
}
