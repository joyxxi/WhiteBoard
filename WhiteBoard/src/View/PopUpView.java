package View;

import javax.swing.*;

/**
 * The class of all pop-up windows view.
 */
public class PopUpView {

    /**
     * The popup window when clicking whiteboard with no shape selected.
     */
    public static void drawNotAllow(JPanel view) {
      JOptionPane.showMessageDialog(
              view, "Have to choose a shape", "Error", JOptionPane.ERROR_MESSAGE);
    }
}
