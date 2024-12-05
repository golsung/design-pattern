public class Paengsu {
    public void move(Mode mode) {
        switch (mode) {
            case WALK:
                walk();
                break;
            case JUMP:
                jump();
                break;
        }
    }
    public void walk() {
        System.out.println("Walking");
    }

    public void jump() {
        System.out.println("Jumping");
    }
}
