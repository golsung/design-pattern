public abstract class MazeFactory {
    public abstract Door makeDoor(Room room1, Room room2);
    public abstract Room makeRoom(int i);
    public Maze makeMaze() { return new Maze();}
    public Wall makeWall() { return new Wall();}
}
