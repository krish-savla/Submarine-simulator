/*
    Name: Krish Savla
    Email: krish.savla@tufts.edu
    Description: class that implements the scroll bar that
    lets it go up and down
*/


import java.awt.event.AdjustmentListener;
import java.awt.event.AdjustmentEvent;

import javax.swing.JScrollBar;

public class Move extends JScrollBar implements AdjustmentListener {
    private String id;
    private Model model;
    public Move (String id, Model m) {
 		model = m;
		// Customize properties of our ScrollBar
		// Named static constant
		setOrientation (VERTICAL);
		setMinimum (25);
		setMaximum (290);
		// Initial value
		setValue (50);

		this.id = id;
		addAdjustmentListener (this);
    }
    // Will make my submarine go up and down
    public void adjustmentValueChanged (AdjustmentEvent event) {
	    System.out.println (id + " : new value = " + getValue());
	    model.update_sub(getValue());

    }
}