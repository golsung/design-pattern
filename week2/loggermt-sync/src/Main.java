public class Main {
    public static void main(String[] args) {
        User[] users = new User[10];
        for (int i = 0; i < 10; i++) {
            users[i] = new User("insang"+i);
            users[i].start();
        }
    }
}
