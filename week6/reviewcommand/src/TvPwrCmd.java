public class TvPwrCmd implements Command {
    private Tv tv;

    public TvPwrCmd(Tv tv) {
        this.tv = tv;
    }

    @Override
    public void execute() {
        tv.power();
    }
}
