import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class SimpleMazeGame {
    public static Maze createMaze() {
        Maze maze = new Maze();

        Room room1 = RoomFactory.createRoom("normal", 1);
        Room room2 = RoomFactory.createRoom("bomb", 2);
        Room room3 = RoomFactory.createRoom("bomb", 3);
        Room room4 = RoomFactory.createRoom("normal", 4);
        Room room5 = RoomFactory.createRoom("normal", 5);
        Room room6 = RoomFactory.createRoom("normal", 6);

        Door door1 = DoorFactory.createDoor("normal", room1, room2, "");
        Door door2 = DoorFactory.createDoor("secret", room1, room4, "insang1");
        Door door3 = DoorFactory.createDoor("normal", room2, room3, "");
        Door door4 = DoorFactory.createDoor("normal", room3, room4, "");
        Door door5 = DoorFactory.createDoor("secret", room4, room5, "insang2");
        Door door6 = DoorFactory.createDoor("normal", room5, room6, "");

        room1.setSide(Direction.NORTH, door1);
        room1.setSide(Direction.EAST, door2);
        room1.setSide(Direction.SOUTH, WallFactory.createWall());
        room1.setSide(Direction.WEST, WallFactory.createWall());

        room2.setSide(Direction.NORTH, WallFactory.createWall());
        room2.setSide(Direction.EAST, door3);
        room2.setSide(Direction.SOUTH, door1);
        room2.setSide(Direction.WEST, WallFactory.createWall());

        room3.setSide(Direction.NORTH, WallFactory.createWall());
        room3.setSide(Direction.EAST, WallFactory.createWall());
        room3.setSide(Direction.SOUTH, door4);
        room3.setSide(Direction.WEST, door3);

        room4.setSide(Direction.NORTH, door4);
        room4.setSide(Direction.EAST, door5);
        room4.setSide(Direction.SOUTH, WallFactory.createWall());
        room4.setSide(Direction.WEST, door2);

        room5.setSide(Direction.NORTH, WallFactory.createWall());
        room5.setSide(Direction.EAST, WallFactory.createWall());
        room5.setSide(Direction.SOUTH, door6);
        room5.setSide(Direction.WEST, door5);

        room6.setSide(Direction.NORTH, door6);
        room6.setSide(Direction.EAST, WallFactory.createWall());
        room6.setSide(Direction.SOUTH, WallFactory.createWall());
        room6.setSide(Direction.WEST, WallFactory.createWall());

        maze.addRoom(room1);
        maze.addRoom(room2);
        maze.addRoom(room3);
        maze.addRoom(room4);
        maze.addRoom(room5);
        maze.addRoom(room6);

        maze.setCurrentRoom(1);

        return maze;
    }


    public static void main(String[] args) {
        Maze maze = createMaze();
        MazeController controller = MazeController.getInstance();
        controller.setMaze(maze);
        controller.setVisible(true);
        controller.setSize(new Dimension(300, 200));
        controller.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
