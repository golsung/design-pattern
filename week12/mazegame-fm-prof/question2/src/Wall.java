public class Wall extends MapSite {
    @Override
    public void enter(Maze maze) {
        MazeController controller = MazeController.getInstance();
        controller.process("벽으로 막혀있어요~~~");
    }
}
