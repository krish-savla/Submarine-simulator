/*
    Name: Krish Savla
    Email: krish.savla@tufts.edu
    Description: class that implements a text field and prints
    out the score or the number of shots the sub hits
*/


import javax.swing.*;
import java.lang.*;

public class Score extends JTextField {
	public Score(String s) {
		JTextField score = new JTextField(s);
	}
	// when the shoot button is pressed, this is updated
	public void score_update() {
		int x = Integer.parseInt(getText());
		x++;
		System.out.println(x);
		setText(String.valueOf(x));
	}

}