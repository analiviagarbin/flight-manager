package forms;

import javax.swing.*;
import java.awt.*;

public class ErrorForm {
    private JFrame frame;
    private JLabel errorMessageLabel;

    public ErrorForm(String errorMessage) {
        frame = new JFrame("Error");
        errorMessageLabel = new JLabel(errorMessage);

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(300, 100);
        frame.setLayout(new FlowLayout());
        frame.add(errorMessageLabel);
    }

    public void display() {
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}