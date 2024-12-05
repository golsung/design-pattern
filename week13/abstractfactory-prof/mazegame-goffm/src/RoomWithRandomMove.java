import java.util.Random;

public class RoomWithRandomMove extends Room {
    public RoomWithRandomMove(int roomNumber) {
        super(roomNumber);
    }

    @Override
    public void enter(Maze maze) {
//        MazeController controller = MazeController.getInstance();
//        controller.process("폭탄이 폭발~ㅠㅠㅠ");
        Random random = new Random();
        int number = random.nextInt(6) + 1;
        maze.setCurrentRoom(number);
    }
}
