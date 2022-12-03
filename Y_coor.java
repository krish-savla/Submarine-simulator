import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class Y_coor extends JTextField implements ActionListener {
    public Y_coor () {
	   super ("200", 3);
	   addActionListener (this);
    }

    public void actionPerformed (ActionEvent e) {
	   System.out.println ("Text: " + e.getActionCommand());
    }
}
