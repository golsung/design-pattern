import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Arrays;

public class MazeController extends JFrame implements KeyListener {
    private JTextArea out;
    private JTextField in;
    private Maze maze;
    private static MazeController instance = null;

    public String getKey() {
        return key;
    }

    private String key;
    private MazeController(){
        out = new JTextArea();
        in = new JTextField();
        this.add(out, BorderLayout.CENTER);
        this.add(in, BorderLayout.SOUTH);
        in.addKeyListener(this);
    }

    public void setMaze(Maze maze) {
        this.maze = maze;
    }

    public static MazeController getInstance() {
        if (instance == null) instance = new MazeController();
        return instance;
    }

    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        switch (code) {
            case KeyEvent.VK_UP:
                process("북쪽으로 이동");
                maze.move( Direction.NORTH);
                break;
            case KeyEvent.VK_DOWN:
                process("남쪽으로 이동");
                maze.move( Direction.SOUTH);
                break;
            case KeyEvent.VK_LEFT:
                process("서쪽으로 이동");
                maze.move( Direction.WEST);
                break;
            case KeyEvent.VK_RIGHT:
                process("동쪽으로 이동");
                maze.move( Direction.EAST);
                break;
            default:
                System.out.println("Key press ignored");
        }
    }
    public void keyReleased(KeyEvent e) {
    }

    public void keyTyped(KeyEvent e) {
        if(e.getKeyChar() == (int)'\n'){
            e.consume();
            key = in.getText();
            process(in.getText());
            in.setText("");
        }
    }

    public void process(String s) {
        String text = out.getText();
        out.setText(text + ((text.length() == 0) ? "" : "\n") + s);
    }
}