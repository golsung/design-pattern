public class Main {
    public static void main(String[] args) {
        Paengsu p = new Paengsu();
        p.setMoving(new Walking());
        p.move();
        p.setMoving(new Jumping());
        p.move();
        p.setMoving(new Flying());
        p.move();
    }
}
