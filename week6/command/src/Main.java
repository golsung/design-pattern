public class Main {
    public static void main(String[] args) {
        TV tv = new TV();
        TwoButtonController rc = new TwoButtonController(tv);
        rc.button1Pressed();
        rc.button2Pressed();
        rc.button1Pressed();
        rc.button2Pressed();
    }
}