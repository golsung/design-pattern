public class AppleFactory {
    private static AppleFactory instance = null;
    private AppleFactory() {};
    public static AppleFactory getInstance() {
        if (instance == null) instance = new AppleFactory();
        return instance;
    }
    public Apple getApple(String kind) {
        Apple apple = null;
        if (kind.equals("busa")) apple = new Busa();
        else if (kind.equals("hongok")) apple = new Hongok();
        else if (kind.equals("hongro")) apple = new Hongro();
        return apple;
    }
}
