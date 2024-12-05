public class RoomWithBomb extends Room {
    public RoomWithBomb(int roomNumber) {
        super(roomNumber);
    }

    @Override
    public void enter(Maze maze) {
        MazeController controller = MazeController.getInstance();
        controller.process("폭탄이 폭발~ㅠㅠㅠ");
        maze.setCurrentRoom(1);
    }
}
