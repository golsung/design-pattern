public class DoorFactory {
    public static Door createDoor(String kind, Room r1, Room r2, String pw) {
        if (kind.equals("secret")) return new SecretDoor(r1, r2, pw);
        return new Door(r1, r2);
    }
}
