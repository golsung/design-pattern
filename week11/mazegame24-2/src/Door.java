import java.util.Scanner;

public class Door extends MapSite {
    protected Room room1;
    protected Room room2;

    public Door(Room room1, Room room2) {
        this.room1 = room1;
        this.room2 = room2;
    }

    @Override
    public void enter(Maze maze) {
            Room otherRoom = otherSideFrom(maze.getCurrentRoom());
            if (otherRoom != null) {
                otherRoom.enter(maze);
            }
    }

    public Room otherSideFrom(Room room) {
        if (room == room1) return room2;
        if (room == room2) return room1;
        return  null;
    }
}
