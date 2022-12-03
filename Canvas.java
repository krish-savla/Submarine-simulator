/*
    Name: Krish Savla
    Email: krish.savla@tufts.edu
    Description: This is the Canvas class which has objects that allow 
    for images to be drawn
*/

import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Graphics2D;
import java.awt.Color;

public class Canvas extends JPanel implements MouseListener {
    private Model model;
    private Main parent;
    Canvas(Model m, Main parent) {
        addMouseListener (this);
        model = m;
        setBackground(Color.blue.darker().darker());
        this.parent = parent;
    }
    // This is the draw callback
    public void paintComponent (Graphics g) {
        // type casting it into a Graphics2D object
        g.setFont(new Font("TimesRoman", Font.PLAIN, 30)); 
        // draws the different shapes
    	super.paintComponent(g);
        model.draw_sub_model(g);
        model.draw_score(g);
        // this is not needed in the game, just helps with drawing
        // model.draw_at_mouse(g);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 30)); 
        model.draw_obs_scores(g); 
        model.draw_obstacles(g);
    }
    
    public void mousePressed (MouseEvent event) {
        System.out.println ("Mouse down at " + event.getPoint().x + ", " + event.getPoint().y);
        model.mouse_coord(event.getPoint().x, event.getPoint().y);
    }

    // MouseListener defines all of these, so we must supply them
    public void mouseReleased (MouseEvent event) {}
    public void mouseClicked (MouseEvent event) {}
    public void mouseEntered (MouseEvent event) {}
    public void mouseExited (MouseEvent event) {}
}