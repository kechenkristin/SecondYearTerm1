package SwingTest;

import javax.swing.*;
import java.awt.*;

public class JLabelTest {
    public static void main(String[] args) {
        JFrame jf = new JFrame();
        jf.setBounds(400, 300, 200, 300);
        jf.setLayout(new FlowLayout());

        // jlabel
        JLabel jLabel = new JLabel("account", SwingConstants.LEFT);
        jf.add(jLabel);

        // jbutton
        JButton b = new JButton("button1");
        b.setEnabled(true);
        jf.add(b);

        jf.setVisible(true);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
