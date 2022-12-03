import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class X_coor extends JTextField implements ActionListener {
    public X_coor () {
	   super ("200", 3);
	   addActionListener (this);
    }

    public void actionPerformed (ActionEvent e) {
	   System.out.println ("Text: " + e.getActionCommand());
    }
}
