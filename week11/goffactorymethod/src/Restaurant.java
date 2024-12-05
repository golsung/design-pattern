public abstract class Restaurant {
    public Apple servingApple(String kind) {
        Apple apple = getApple(kind);
        apple.wash();
        apple.peel();
        apple.slice();
        return apple;
    }

    public abstract Apple getApple(String kind);
}
