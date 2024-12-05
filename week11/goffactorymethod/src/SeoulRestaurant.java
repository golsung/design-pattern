public class SeoulRestaurant extends Restaurant {
    @Override
    public Apple getApple(String kind) {
        Apple apple = null;
        if (kind.equals("busa")) apple = new Busa();
        if (kind.equals("hongok")) apple = new Hongok();
        if (kind.equals("hongro")) apple = new Hongro();
        return apple;
    }
}
