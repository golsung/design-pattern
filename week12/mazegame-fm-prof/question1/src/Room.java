public class Room extends MapSite {
    protected int roomNumber = 0;
    protected MapSite[] sides = new MapSite[4];

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Room(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    @Override
    public void enter(Maze maze) {
        maze.setCurrentRoom(this);
    }
    public void setSide(Direction dir, MapSite site) {
        sides[dir.getValue()] = site;
    }
    public MapSite getSide(Direction dir) {
        return sides[dir.getValue()];
    }
}
