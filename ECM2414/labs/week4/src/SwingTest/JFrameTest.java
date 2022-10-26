package SwingTest;

import javax.swing.*;

public class JFrameTest {
    public static void main(String[] args) {
        JFrame jf = new JFrame("JFrame");

        // equals to jf.setBounds(400, 300, 400, 250)
        jf.setSize(400, 250);
        jf.setLocation(400, 300);


        jf.setVisible(true);    // must
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JDialog jd = new JDialog(jf, "JDialog");
        jd.setBounds(400, 300, 200, 200);
        jd.setVisible(true);
        jd.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }
}
