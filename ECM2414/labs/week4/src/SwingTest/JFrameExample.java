package SwingTest;

import javax.swing.*;
import java.awt.*;

public class JFrameExample {
    public static void main(String[] args) {
        JFrame jf = new JFrame("Frame");
        jf.setLayout(new FlowLayout());
        jf.setBounds(400, 300, 200, 300);

        // codes put here

        jf.setVisible(true);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
