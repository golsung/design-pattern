public class RoomFactory {
    public static Room createRoom(String kind, int num) {
        if (kind.equals("bomb")) return new RoomWithBomb(num);
        return new Room(num);
    }
}
