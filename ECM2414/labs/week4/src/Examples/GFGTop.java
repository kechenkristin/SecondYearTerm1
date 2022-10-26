package Examples;
// Java program to demonstrate the
// event handling within the class

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GFGTop extends JFrame implements ActionListener {

    TextField textField;

    GFGTop() {
        this.setBounds(400, 300, 400, 300);

        // Component Creation
        textField = new TextField();

        // setBounds method is used to provide
        // position and size of the component
        textField.setBounds(60, 50, 180, 25);
        JButton button = new JButton("click Here");
        button.setBounds(100, 120, 80, 30);

        // Registering component with listener
        // this refers to current instance
        button.addActionListener(this);

        // add Components
        add(textField);
        add(button);

        // set visibility
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    // implementing method of actionListener
    public void actionPerformed(ActionEvent e) {
        // Setting text to field
        textField.setText("GFG!");
    }

    public static void main(String[] args) {
        new GFGTop();
    }
}
