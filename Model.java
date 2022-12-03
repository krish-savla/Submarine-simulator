/*
	Name: Krish Savla
 	Email: krish.savla@tufts.edu
 	Description: This class is the model class, it connects 
 	all the widgets to the canvas class
*/

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.*;
import java.util.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;

public class Model {
	private Canvas canvas;
	private int canvas_x;
	private int canvas_y;
	private Submarine sub;
	private int choice = 1;
	private int score;
	private int mouse_x;
	private int mouse_y;
	private Obstacles ob;
	private ArrayList<Obstacles> obstacles;
	private ArrayList<Obstacles> obstacles2;
	public Model() {
		sub = new Submarine();
		obstacles = new ArrayList<Obstacles>(5); 
		populate_obstacles();
	}
	public void update_score() {
		score = score + 1;
		canvas.repaint();
	}
	public void draw_score(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;	
		g2.setColor(Color.white);
		g2.drawString(String.valueOf(score), 250, 40);
		g2.setColor(Color.gray);
	}

	public void draw_obs_scores(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;	
		g2.setColor(Color.white);
		g2.drawString("Obstacles: ", 150, 320);
		// gets the number of obstacles and draws the length
		g2.drawString(String.valueOf(obstacles.size()), 300, 320);
		g2.setColor(Color.gray);
	}

	public void draw_sub_model(Graphics g) {
		// choices are for colors
		if (choice == 1)
			sub.draw_sub(g);
		if (choice == 2)
			sub.draw_sub2(g);
	}
	public void color_choice(int choice) {
		// changes sub color
		this.choice = choice;
		canvas.repaint();
	}
	public void update_sub(int y_new) {
		// helps sub move
		sub.update_coordinates(y_new);
		canvas.repaint();
    }
    public void canvas_setter(Canvas c) {
    	canvas = c;
    }
    public void change_mode_dark() {
    	// changes background color to dark mode
    	canvas.setBackground(Color.black);
    	canvas.repaint();

    }
    public void change_mode_light() {
    	// changes background color to light mode
    	canvas.setBackground(Color.blue.darker().darker());
    	canvas.repaint();
    }
    public void mouse_coord(int x, int y) {
    	mouse_x = x;
    	mouse_y = y;
    	for (int i = 0; i < obstacles.size(); i++) {
    		// going through the list of obstacles
    		if (((obstacles.get(i)).get_oval()).contains(x, y))
    		{
    			// updating size if the mouse click is in the
    			// object
    			obstacles.get(i).update_size(40, 20);
    			ob = obstacles.get(i);
    		}
    		canvas.repaint();
    	}
    }
    public void draw_at_mouse(Graphics g) {
    	// not currently needed, helps to draw
    	Graphics2D g2 = (Graphics2D) g;
    	g2.fillRect(mouse_x, mouse_y, 30, 30);
    	canvas.repaint();
    }
    public void populate_obstacles() {
    	// adding default objects
    	Fish f1 = new Fish(400, 100);
    	Fish f2 = new Fish(380, 60);
    	Fish f3 = new Fish(400, 280);
    	Shark s1 = new Shark(420, 300);
    	Shark s2 = new Shark(410, 200);
    	Shark s3 = new Shark(390, 160);
    	obstacles.add(f1);
    	obstacles.add(f2);
    	obstacles.add(f3);
    	obstacles.add(s1);
    	obstacles.add(s2);
    	obstacles.add(s3);
    }
    public void draw_obstacles(Graphics g) {
    	// drawing all the objects
    	for (int i = 0; i < obstacles.size(); i++) {
    		(obstacles.get(i)).draw_obstacle(g);
    	}
    	collisions();
    }
    public void add_obstacle(int type, int x, int y) {
    	if (type == 1) {
    		Fish f = new Fish(x, y);
    		obstacles.add(f);
    	}
    	else {
    		Shark s = new Shark(x, y);
    		obstacles.add(s);
    	}
    	canvas.repaint();
    }
    public void change_obstacle_pos(int speed) {
    	for (int i = 0; i < obstacles.size(); i++) {
    		(obstacles.get(i)).set_x(speed);
    	}
    }
    public void collisions() {
    	for (int i = 0; i < obstacles.size(); i++) {
    		int x = (obstacles.get(i)).get_x();
    		int y = (obstacles.get(i)).get_y();
    		int w = (obstacles.get(i)).get_w();
    		int h = (obstacles.get(i)).get_h();
    		// checking for collision
    		if ((sub.get_sub()).intersects(x, y, w, h)) {
    			if (obstacles.get(i) == ob) {
    				ob = null;
    			}
    			obstacles.remove(i);
    			update_score();
    		}
    	}
    	canvas.repaint();
    }
    public void update_obs_color() {
    	if (ob != null) {
    		((ob)).set_color(Color.red);
    	}
    	canvas.repaint();
    }
    public void zoom_in() {
    	canvas_x = (canvas.getSize()).height / 2;
    	canvas_y = (canvas.getSize()).width / 2;

    	// updating obstacle position
    	for (Obstacles obs : obstacles) {
    		obs.change_x(obs.get_x() - canvas_x);
    		obs.change_y(obs.get_y() - canvas_y);
    		obs.change_x(obs.get_x() * 2);
    		obs.change_y(obs.get_y() * 2);
    		obs.change_x(obs.get_x() + canvas_x);
    		obs.change_y(obs.get_y() + canvas_y);	
    	}
    	// updating sub position
    	sub.set_x(sub.get_x() - canvas_x);
    	sub.set_y(sub.get_y() - canvas_y);
    	sub.set_x(sub.get_x() * 2);
    	sub.set_y(sub.get_y() * 2);
    	sub.set_x(sub.get_x() + canvas_x);
    	sub.set_y(sub.get_y() + canvas_y);	
    	canvas.repaint();
    }
    public void zoom_out() {
    	canvas_x = (canvas.getSize()).height / 2;
    	canvas_y = (canvas.getSize()).width / 2;

    	// updating obstacle position
    	for (Obstacles obs : obstacles) {
    		obs.change_x(obs.get_x() - canvas_x);
    		obs.change_y(obs.get_y() - canvas_y);
    		obs.change_x(obs.get_x() / 2);
    		obs.change_y(obs.get_y() / 2);
    		obs.change_x(obs.get_x() + canvas_x);
    		obs.change_y(obs.get_y() + canvas_y);	
    	}
    	// updating sub position
    	sub.set_x(sub.get_x() - canvas_x);
    	sub.set_y(sub.get_y() - canvas_y);
    	sub.set_x(sub.get_x() / 2);
    	sub.set_y(sub.get_y() / 2);
    	sub.set_x(sub.get_x() + canvas_x);
    	sub.set_y(sub.get_y() + canvas_y);	
    	canvas.repaint();
    }



}