public class MyMazeCreator extends MazeCreator {

    @Override
    public Door makeDoor(Room room1, Room room2) {
        if (room1.getRoomNumber() == 1 && room2.getRoomNumber() == 4)
            return new SecretDoor(room1, room2, "insang1");
        if (room1.getRoomNumber() == 4 && room2.getRoomNumber() == 5)
            return new SecretDoor(room1, room2, "insang2");
        return new Door(room1, room2);
    }

    @Override
    public Room makeRoom(int i) {
        if (i == 2) return new RoomWithBomb(i);
        if (i == 3) return new RoomWithRandomMove(i);
        return new Room(i);
    }

}
