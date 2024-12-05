public class Restaurant {
    public Apple servingApple(String kind) {
        AppleFactory factory = AppleFactory.getInstance();
        Apple apple = factory.getApple(kind);
//        Apple apple = AppleFactory.getApple(kind);
        apple.wash();
        apple.peel();
        apple.slice();
        return apple;
    }
}
