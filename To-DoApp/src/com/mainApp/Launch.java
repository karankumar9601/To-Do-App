package com.mainApp;
import com.ui.ToDoAppUI;
import javax.swing.SwingUtilities;
public class Launch {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ToDoAppUI().setVisible(true);
        });
    }
}

