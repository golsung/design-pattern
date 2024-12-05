import java.util.Optional;

public class TicketManager {
    private int count;
    private final int LIMITS = 2;
    public TicketManager() {
        count = 0;
    }
    public   Optional<Ticket> issue() {
        if (count >= LIMITS) return Optional.empty();
        return Optional.of(new Ticket(count++));
    }
}
