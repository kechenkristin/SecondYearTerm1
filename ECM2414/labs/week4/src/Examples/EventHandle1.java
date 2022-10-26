package Examples;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventHandle1 extends JFrame implements ActionListener {

    JButton b;
    JTextField tf;

    EventHandle1() {
        this.setBounds(400, 300, 400, 300);

        b = new JButton("click");
        b.setBounds(100, 120, 80, 30);
        tf = new JTextField();
        tf.setBounds(100, 100, 100, 100);


        b.addActionListener(this);      // register

        add(b);
        add(tf);

        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String str = actionEvent.getActionCommand();
        tf.setText(str);
    }

    public static void main(String[] args) {
        new EventHandle1();
    }
}
