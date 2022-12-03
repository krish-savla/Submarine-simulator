/*
    Name: Krish Savla
    Email: krish.savla@tufts.edu
    Description: class that implements a button that changes obstacles'
    color
*/

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Change_obs_color extends JButton implements ActionListener {
    private Model model;
    public Change_obs_color (String label, Model m) {
        model = m;
	    setText (label);
        addActionListener (this);
    }
    public void actionPerformed (ActionEvent e) {
        System.out.println ("color changed!");
        model.update_obs_color();
    }
}