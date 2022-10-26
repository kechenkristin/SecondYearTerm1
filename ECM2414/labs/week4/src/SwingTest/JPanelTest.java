package SwingTest;

import javax.swing.*;
import java.awt.*;

public class JPanelTest {
    public static void main(String[] args) {
        JFrame jf = new JFrame("Frame");
        jf.setBounds(400, 300, 1000, 1300);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JButton b1 = new JButton("button1");
        JButton b2 = new JButton("button2");

        JPanel jp = new JPanel(new FlowLayout());
        jp.add(b1);
        jp.add(b2);
        jf.add(jp);
    }
}
