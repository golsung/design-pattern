import java.util.Random;

public class User extends Thread {
    public User(String name) { super(name); }
    public void run() {
        Random r = new Random();
        Account acct = new Account(Thread.currentThread().getName(), r.nextInt(1000000));
        if (r.nextBoolean()) acct.withdraw(r.nextInt(acct.getBalance()));
        else acct.deposit(r.nextInt(acct.getBalance()));
    }
}
