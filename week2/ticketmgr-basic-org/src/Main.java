import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        TicketManager tm1 = new TicketManager();
        Optional<Ticket> t1 = tm1.issue();
        t1.ifPresent(s->System.out.println(s.getSerialNum()));

        Optional<Ticket> t2 = tm1.issue();
        t2.ifPresent(s->System.out.println(s.getSerialNum()));

        Optional<Ticket> t3 = tm1.issue();
        t3.ifPresent(s->System.out.println(s.getSerialNum()));

        TicketManager tm2 = new TicketManager();
        Optional<Ticket> t4 = tm2.issue();
        t4.ifPresent(s->System.out.println(s.getSerialNum()));
    }
}
