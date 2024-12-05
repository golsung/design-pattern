import java.util.ArrayList;
import java.util.List;

public class Maze {
    protected List<Room> rooms = new ArrayList<>();
    protected Room curRoom = null;

    public Room getCurrentRoom() {
        return curRoom;
    }

    public void setCurrentRoom(Room curRoom) {
        this.curRoom = curRoom;
        MazeController controller = MazeController.getInstance();
        controller.process("방"+curRoom.getRoomNumber()+"에 들어 왔습니다.");
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public Room findRoom(int roomNumber) {
        for (Room room : rooms) {
            if (roomNumber == room.getRoomNumber()) {
                return room;
            }
        }
        return null;
    }

    public void setCurrentRoom(int roomNumber) {
        Room room = findRoom(roomNumber);
        setCurrentRoom(room);
    }

    public void move(Direction direction) {
        MapSite side = curRoom.getSide(direction);
        if (side != null) side.enter(this);
    }

}
