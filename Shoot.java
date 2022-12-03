/*
    Name: Krish Savla
    Email: krish.savla@tufts.edu
    Description: class that implements a button that shoots out
    from the sub
*/

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Shoot extends JButton implements ActionListener {
    private Model model;
    public Shoot (String label, Model m) {
        model = m;
	    setText (label);
        addActionListener (this);
    }
    public void actionPerformed (ActionEvent e) {
        System.out.println ("BOOM!");
        model.update_score();
    }
}