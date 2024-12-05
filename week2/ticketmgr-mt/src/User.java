import java.util.Optional;

public class User extends Thread{
    public User(String name) {
        super(name);
    }
    public void run() {
        TicketManager mgr = TicketManager.getInstance();
//        System.out.println(Thread.currentThread().getName() + " " + mgr.toString());
        Optional<Ticket> t = mgr.issue();
        t.ifPresent(s->System.out.println(Thread.currentThread().getName() + " " + mgr +
                " end watching Movie with " + s.getSerialNum()));
    }
}
