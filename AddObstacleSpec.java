/*
    Name: Krish Savla
    Email: krish.savla@tufts.edu
    Description: class that implements a button that 
    exits from the game
*/

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.border.TitledBorder;
import javax.swing.*;
import java.awt.Color;

public class AddObstacleSpec extends JPanel {
    public AddObstacleSpec (ObstacleType obs, X_coor xc, Y_coor yc) {
        setLayout(new GridLayout(4,1));
        // Adding a specific title to the page
        TitledBorder border = new TitledBorder("ADD OBSTACLE");
        border.setTitleJustification(TitledBorder.CENTER);
        border.setTitlePosition(TitledBorder.TOP);
        
        setBorder(border);
        add(obs);
        add(xc);
        add(yc);
    }
}
