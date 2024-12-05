public class Main {
    public static void main(String[] args) {
        Adder adder = new MyAdder();
        UseAdder use = new UseAdder();
        System.out.println(use.add(adder, 10, 20));
        Adder adder1 = new YourAdderAdapter(new YourAdder());
        System.out.println(use.add(adder1, 10, 20));
    }
}
