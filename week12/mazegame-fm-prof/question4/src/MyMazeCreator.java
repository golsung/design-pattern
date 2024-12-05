public class MyMazeCreator extends MazeCreator {
    public  Maze createMaze() {
        Maze maze = makeMaze();

        Room room1 = makeRoom(1);
        Room room2 = makeRoom(4);
        Room room3 = makeRoom(5);
        Room room4 = makeRoom(6);


        Door door1 = makeDoor(room1, room2);
        Door door2 = makeDoor(room2, room3);
        Door door3 = makeDoor(room3, room4);


        room1.setSide(Direction.EAST, door1);
        room1.setSide(Direction.NORTH, new Wall());
        room1.setSide(Direction.SOUTH, new Wall());
        room1.setSide(Direction.WEST, new Wall());

        room2.setSide(Direction.NORTH, new Wall());
        room2.setSide(Direction.EAST, door2);
        room2.setSide(Direction.SOUTH, new Wall());
        room2.setSide(Direction.WEST, door1);

        room3.setSide(Direction.NORTH, new Wall());
        room3.setSide(Direction.EAST, new Wall());
        room3.setSide(Direction.SOUTH, door3);
        room3.setSide(Direction.WEST,door2);

        room4.setSide(Direction.NORTH, door3);
        room4.setSide(Direction.EAST, new Wall());
        room4.setSide(Direction.SOUTH, new Wall());
        room4.setSide(Direction.WEST, new Wall());

        maze.addRoom(room1);
        maze.addRoom(room2);
        maze.addRoom(room3);
        maze.addRoom(room4);


        maze.setCurrentRoom(1);

        return maze;

    }
    @Override
    public Door makeDoor(Room room1, Room room2) {
        if (room1.getRoomNumber() == 4 && room2.getRoomNumber() == 5)
            return new SecretDoor(room1, room2, "insang1");
        if (room1.getRoomNumber() == 5 && room2.getRoomNumber() == 6)
            return new SecretDoor(room1, room2, "insang2");
        return new Door(room1, room2);
    }

}
