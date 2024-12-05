import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class MazeGame {
    public  Maze createMaze(MazeFactory factory) {
        Maze maze = factory.makeMaze();

        Room room1 = factory.makeRoom(1);
        Room room2 = factory.makeRoom(2);
        Room room3 = factory.makeRoom(3);
        Room room4 = factory.makeRoom(4);
        Room room5 = factory.makeRoom(5);
        Room room6 = factory.makeRoom(6);


        Door door1 = factory.makeDoor(room1, room2);
        Door door2 = factory.makeDoor(room1, room4);
        Door door3 = factory.makeDoor(room2, room3);
        Door door4 = factory.makeDoor(room3, room4);
        Door door5 = factory.makeDoor(room4, room5);
        Door door6 = factory.makeDoor(room5, room6);

        room1.setSide(Direction.NORTH, door1);
        room1.setSide(Direction.EAST, door2);
        room1.setSide(Direction.SOUTH, factory.makeWall());
        room1.setSide(Direction.WEST, factory.makeWall());

        room2.setSide(Direction.NORTH, factory.makeWall());
        room2.setSide(Direction.EAST, door3);
        room2.setSide(Direction.SOUTH, door1);
        room2.setSide(Direction.WEST, factory.makeWall());

        room3.setSide(Direction.NORTH, factory.makeWall());
        room3.setSide(Direction.EAST, factory.makeWall());
        room3.setSide(Direction.SOUTH, door4);
        room3.setSide(Direction.WEST,door3);

        room4.setSide(Direction.NORTH, door4);
        room4.setSide(Direction.EAST, door5);
        room4.setSide(Direction.SOUTH, factory.makeWall());
        room4.setSide(Direction.WEST, door2);

        room5.setSide(Direction.NORTH, factory.makeWall());
        room5.setSide(Direction.EAST, factory.makeWall());
        room5.setSide(Direction.SOUTH, door6);
        room5.setSide(Direction.WEST, door5);

        room6.setSide(Direction.NORTH, door6);
        room6.setSide(Direction.EAST, factory.makeWall());
        room6.setSide(Direction.SOUTH, factory.makeWall());
        room6.setSide(Direction.WEST, factory.makeWall());


        maze.addRoom(room1);
        maze.addRoom(room2);
        maze.addRoom(room3);
        maze.addRoom(room4);
        maze.addRoom(room5);
        maze.addRoom(room6);

        maze.setCurrentRoom(1);

        return maze;
    }

    public Maze makeMaze() {
        return new Maze();
    }

    public Wall makeWall() {
        return new Wall();
    }

    public Room makeRoom(int i) {
        return new Room(i);
    }
    public Door makeDoor(Room room1, Room room2) {
        return new Door(room1, room2);
    }


    public static void main(String[] args) {
        MazeGame mazeCreator = new MazeGame();
        Maze maze = mazeCreator.createMaze(new MyMazeFactory());
        MazeController controller = MazeController.getInstance();
        controller.setMaze(maze);
        controller.setVisible(true);
        controller.setSize(new Dimension(300, 200));
        controller.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
