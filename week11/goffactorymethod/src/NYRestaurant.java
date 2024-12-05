public class NYRestaurant extends Restaurant {
    @Override
    public Apple getApple(String kind) {
        Apple apple = null;
        if (kind.equals("koru"))apple = new Koru();
        else if(kind.equals("crispy"))apple =new Everycrispy();
        else if (kind.equals("pl"))apple =new Pinklady();
        return apple;
    }
}
