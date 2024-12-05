public class BirdSingCmd implements Command {
    private Bird bird;

    public BirdSingCmd(Bird bird) {
        this.bird = bird;
    }

    @Override
    public void execute() {
        bird.sing();
    }
}
