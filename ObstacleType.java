import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class ObstacleType extends JComboBox<String> implements ItemListener {
	private Model model;
	private X_coor xc;
	private Y_coor yc;
    public ObstacleType (Model m, X_coor x, Y_coor y) {
    	xc = x;
    	yc = y;
    	model = m;
		addItem ("Fish");
		addItem ("Shark");
		setSelectedItem ("Fish");
		addItemListener (this);
    }

    public void itemStateChanged (ItemEvent e) {
		if (e.getStateChange() == ItemEvent.SELECTED) {
	    	System.out.println ("picked: " + e.getItem());
	    	int x_coord = Integer.parseInt(xc.getText());
	    	int y_coord = Integer.parseInt(yc.getText());

	    	if (e.getItem().equals("Fish")) {
	    		System.out.println("x " + x_coord);
	    		System.out.println("y " + y_coord);

	    		model.add_obstacle(1, x_coord, y_coord);
	    	}
	    	else {
	    		model.add_obstacle(2, x_coord, y_coord);
	    	}
		}
    }
}
