import java.util.Scanner;

public class SecretDoor extends Door {

    protected String correctKey;

    public SecretDoor(Room room1, Room room2, String correctKey) {
        super(room1, room2);
        this.correctKey = correctKey;
    }

    public String getCorrectKey() {
        return correctKey;
    }

    public void setCorrectKey(String correctKey) {
        this.correctKey = correctKey;
    }

//    public SecretDoor(Room room1, Room room2) {
//        super(room1, room2);
//    }

    @Override
    public void enter(Maze maze) {
            Scanner sc = new Scanner(System.in);
            MazeController controller = MazeController.getInstance();
            System.out.print("비밀번호는? ");
            String key = sc.nextLine();
            if (key.equals(correctKey)) {
                Room otherRoom = otherSideFrom(maze.getCurrentRoom());
                if (otherRoom != null) {
                    otherRoom.enter(maze);
                }
            } else {
                System.out.print("비밀번호가 틀려요~");
            }
    }

    public Room otherSideFrom(Room room) {
        if (room == room1) return room2;
        if (room == room2) return room1;
        return  null;
    }
}
