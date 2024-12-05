public class RoomWithCursedMove extends Room {
    public RoomWithCursedMove(int roomNumber) {
        super(roomNumber);
    }

    @Override
    public void enter(Maze maze) {
        maze.setCurrentRoom(1);
    }
}
