/*
    Name: Krish Savla
    Email: krish.savla@tufts.edu
    Description: class that adds a random obstacle
*/

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Add_obstacle extends JButton implements ActionListener {
    private Model model;
    public Add_obstacle(String label, Model m) {
        model = m;
	    setText (label);
        addActionListener (this);
    }
    public void actionPerformed (ActionEvent e) {
        System.out.println ("obstacle added");
        int type = (int) (Math.random() * 2) + 1;
        int x_dim = (int) (Math.random() * 300) + 100;
        int y_dim = (int) (Math.random() * 300) + 0;
        model.add_obstacle(type, x_dim, y_dim);
    }
}