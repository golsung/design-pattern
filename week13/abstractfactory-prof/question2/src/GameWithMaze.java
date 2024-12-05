import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.time.Instant;

// MazeMap 추상 클래스
abstract class MazeMap {
    protected int[][] map;

    public int[][] getMap() {
        return map;
    }

    public abstract int getGoalX();

    public abstract int getGoalY();

    public Point validateMove(int currentX, int currentY, int deltaX, int deltaY) {
        int newX = currentX + deltaX;
        int newY = currentY + deltaY;
        if (newX >= 0 && newX < map[0].length && newY >= 0 && newY < map.length && map[newY][newX] != 1) {
            return new Point(newX, newY);
        }
        return new Point(currentX, currentY);
    }

    public boolean isGoal(int x, int y) {
        return x == getGoalX() && y == getGoalY();
    }

    public boolean isTrap(int x, int y) {
        return false; // 기본적으로 함정 없음
    }
}

// SimpleMazeMap 클래스
class SimpleMazeMap extends MazeMap {
    public SimpleMazeMap() {
        this.map = new int[][]{
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 0, 0, 0, 0, 1, 0, 0, 0, 1},
                {1, 0, 1, 1, 0, 1, 0, 1, 0, 1},
                {1, 0, 0, 1, 0, 0, 0, 1, 0, 1},
                {1, 1, 0, 1, 1, 1, 0, 1, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 1, 1, 1, 1, 1, 1, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 2, 1}
        };
    }

    @Override
    public int getGoalX() {
        return 8;
    }

    @Override
    public int getGoalY() {
        return 8;
    }
}

// AdvancedMazeMap 클래스 - 14x10 크기의 복잡한 미로를 제공
class AdvancedMazeMap extends MazeMap {
    public AdvancedMazeMap() {
        this.map = new int[][]{
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 1},
                {1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1},
                {1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1},
                {1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 0, 1},
                {1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1},
                {1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1},
                {1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 1}
        };
    }

    @Override
    public int getGoalX() {
        return 12;
    }

    @Override
    public int getGoalY() {
        return 9;
    }
}

// TrappedMazeMap 클래스
class TrappedMazeMap extends MazeMap {
    public TrappedMazeMap() {
        this.map = new int[][]{
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 0, 0, 0, 0, 1, 0, 0, 0, 1},
                {1, 0, 1, 1, 0, 1, 0, 1, 0, 1},
                {1, 0, 0, 1, 3, 0, 0, 1, 0, 1},
                {1, 1, 0, 1, 1, 1, 0, 1, 0, 1},
                {1, 0, 0, 0, 0, 0, 3, 0, 0, 1},
                {1, 0, 1, 1, 1, 1, 1, 1, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 2, 1}
        };
    }

    @Override
    public int getGoalX() {
        return 8;
    }

    @Override
    public int getGoalY() {
        return 8;
    }

    @Override
    public boolean isTrap(int x, int y) {
        return map[y][x] == 3;
    }
}

// Player 추상 클래스
abstract class Player {
    protected int x = 1, y = 1;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void move(MazeMap map, int deltaX, int deltaY) {
        Point newPosition = map.validateMove(x, y, deltaX, deltaY);
        x = newPosition.x;
        y = newPosition.y;
        if (map.isTrap(x, y)) {
            handleTrap();
        }
    }


    public boolean reachedGoal(MazeMap map) {
        return map.isGoal(x, y);
    }

    public abstract void moveUp(MazeMap map);

    public abstract void moveDown(MazeMap map);

    public abstract void moveLeft(MazeMap map);

    public abstract void moveRight(MazeMap map);

    protected void handleTrap() {
        JOptionPane.showMessageDialog(null, "You fell into a trap! Restarting...");
        x = 1;
        y = 1;
    }
}

// BasicPlayer 클래스
class BasicPlayer extends Player {
    @Override
    public void moveUp(MazeMap map) {
        move(map, 0, -1);
    }

    @Override
    public void moveDown(MazeMap map) {
        move(map, 0, 1);
    }

    @Override
    public void moveLeft(MazeMap map) {
        move(map, -1, 0);
    }

    @Override
    public void moveRight(MazeMap map) {
        move(map, 1, 0);
    }
}

// FastPlayer 클래스
class FastPlayer extends Player {
    @Override
    public void moveUp(MazeMap map) {
        if (map.validateMove(x, y, 0, -2).y == y - 2) move(map, 0, -2);
        else move(map, 0, -1);
    }

    @Override
    public void moveDown(MazeMap map) {
        if (map.validateMove(x, y, 0, 2).y == y + 2) move(map, 0, 2);
        else move(map, 0, 1);
    }

    @Override
    public void moveLeft(MazeMap map) {
        if (map.validateMove(x, y, -2, 0).x == x - 2) move(map, -2, 0);
        else move(map, -1, 0);
    }

    @Override
    public void moveRight(MazeMap map) {
        if (map.validateMove(x, y, 2, 0).x == x + 2) move(map, 2, 0);
        else move(map, 1, 0);
    }
}

// StrongPlayer 클래스
class StrongPlayer extends Player {
    @Override
    public void moveUp(MazeMap map) {
        x += 0;
        y = Math.max(y - 1, 0); // 무조건 한 칸 위로 이동
    }

    @Override
    public void moveDown(MazeMap map) {
        x += 0;
        y = Math.min(y + 1, map.getMap().length - 1); // 무조건 한 칸 아래로 이동
    }

    @Override
    public void moveLeft(MazeMap map) {
        y += 0;
        x = Math.max(x - 1, 0); // 무조건 한 칸 왼쪽으로 이동
    }

    @Override
    public void moveRight(MazeMap map) {
        y += 0;
        x = Math.min(x + 1, map.getMap()[0].length - 1); // 무조건 한 칸 오른쪽으로 이동
    }
}


// MazeWithPlayerFactory 추상 클래스
abstract class MazeWithPlayerFactory {
    public abstract MazeMap createMazeMap();

    public abstract Player createPlayer();
}

// SimpleMazeWithBasicPlayerFactory 클래스
class SimpleMazeWithBasicPlayerFactory extends MazeWithPlayerFactory {
    @Override
    public MazeMap createMazeMap() {
        return new SimpleMazeMap();
    }

    @Override
    public Player createPlayer() {
        return new BasicPlayer();
    }
}

// AdvancedMazeWithFastPlayerFactory 클래스
class AdvancedMazeWithFastPlayerFactory extends MazeWithPlayerFactory {
    @Override
    public MazeMap createMazeMap() {
        return new AdvancedMazeMap();
    }

    @Override
    public Player createPlayer() {
        return new FastPlayer();
    }
}

class AdvancedMazeWithBasicPlayerFactory extends MazeWithPlayerFactory {
    @Override
    public MazeMap createMazeMap() {
        return new AdvancedMazeMap();
    }

    @Override
    public Player createPlayer() {
        return new BasicPlayer();
    }
}

class TrappedMazeWithBasicPlayerFactory extends MazeWithPlayerFactory {
    @Override
    public MazeMap createMazeMap() {
        return new TrappedMazeMap();
    }

    @Override
    public Player createPlayer() {
        return new BasicPlayer();
    }
}

// GamePanel 클래스
class GamePanel extends JPanel {
    private final MazeMap map;
    private final Player player;
    private final Instant startTime;
    private final int tileSize = 20;

    public GamePanel(MazeWithPlayerFactory factory) {
        this.map = factory.createMazeMap();
        this.player = factory.createPlayer();
        this.startTime = Instant.now();
        setPreferredSize(new Dimension(tileSize * map.getMap()[0].length, tileSize * map.getMap().length));
        setBackground(Color.WHITE);
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP -> player.moveUp(map);
                    case KeyEvent.VK_DOWN -> player.moveDown(map);
                    case KeyEvent.VK_LEFT -> player.moveLeft(map);
                    case KeyEvent.VK_RIGHT -> player.moveRight(map);
                }
                if (player.reachedGoal(map)) {
                    long seconds = Duration.between(startTime, Instant.now()).getSeconds();
                    JOptionPane.showMessageDialog(GamePanel.this, "You reached the goal in " + seconds + " seconds!");
                }
                repaint();
            }
        });
        setFocusable(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (int row = 0; row < map.getMap().length; row++) {
            for (int col = 0; col < map.getMap()[0].length; col++) {
                if (map.getMap()[row][col] == 1) {
                    g.setColor(Color.BLACK);
                    g.fillRect(col * tileSize, row * tileSize, tileSize, tileSize);
                } else if (map.getMap()[row][col] == 2) {
                    g.setColor(Color.RED);
                    g.fillRect(col * tileSize, row * tileSize, tileSize, tileSize);
                } else if (map.getMap()[row][col] == 3) {
                    g.setColor(Color.ORANGE);
                    g.fillRect(col * tileSize, row * tileSize, tileSize, tileSize);
                }
            }
        }

        g.setColor(Color.BLUE);
        g.fillOval(player.getX() * tileSize, player.getY() * tileSize, tileSize, tileSize);
    }
}

// GameWithMaze 클래스
public class GameWithMaze extends JFrame {
    public GameWithMaze(MazeWithPlayerFactory factory) {
        setTitle("Maze Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(new GamePanel(factory));
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GameWithMaze(new TrappedMazeWithBasicPlayerFactory())); // 원하는 MazeFactory 선택 가능
    }
}
