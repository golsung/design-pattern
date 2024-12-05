public class Home {
    public Apple getAppleForBreakfast(String kind) {
        AppleFactory factory = AppleFactory.getInstance();
        Apple apple = factory.getApple(kind);
//        Apple apple = AppleFactory.getApple(kind);
        apple.wash();
        return apple;
    }
}
