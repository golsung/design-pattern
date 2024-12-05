public class FileNewCmd implements Command {
    private FileNew f;

    public FileNewCmd(FileNew f) {
        this.f = f;
    }

    @Override
    public void execute() {
        f.open();
    }
}
