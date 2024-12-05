public abstract class ParcelItem {
    protected int weight;
    public ParcelItem(int weight) {
        this.weight = weight;
    }
    public abstract int price();
}
