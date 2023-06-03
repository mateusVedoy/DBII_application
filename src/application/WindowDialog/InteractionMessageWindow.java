package application.WindowDialog;

import javax.swing.*;

public class InteractionMessageWindow {
    public void messageDialog(String message) {
        JOptionPane.showMessageDialog(null, message);
    }

    public String messageInputDialog(String message) {
        return JOptionPane.showInputDialog(message);
    }
}
