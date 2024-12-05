public class YourAdderAdapter implements Adder {
    private YourAdder yourAdder;
    public YourAdderAdapter(YourAdder yourAdder) {
        this.yourAdder = yourAdder;
    }
    @Override
    public int plus(int x, int y) {
        return yourAdder.add3(x, y, 0);
    }
}
