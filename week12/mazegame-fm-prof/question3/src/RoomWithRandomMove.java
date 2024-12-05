import java.util.Random;

public class RoomWithRandomMove extends Room {
    public RoomWithRandomMove(int roomNumber) {
        super(roomNumber);
    }

    @Override
    public void enter(Maze maze) {
        Random random = new Random();
        int number = random.nextInt(6) + 1;
        maze.setCurrentRoom(number);
    }
}
