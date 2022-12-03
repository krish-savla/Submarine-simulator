/*
	Name: Krish Savla
 	Email: krish.savla@tufts.edu
 	Description: This class is the main class, it contains the main loop that links
 	all the other classes together
*/

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.*;
import java.awt.Color;


public class Main extends JFrame implements ActionListener {
	private Model model;
	private Canvas canvas;
	private Score score;
	private Move move;
	private Change_color change_color;
	private Add_obstacle add_obstacle;
	private X_coor xc;
	private Y_coor yc;
	private Night_mode night_mode;
	private Shoot shoot;
	private Change_obs_color change_obs_color;
	private ObstacleType obstacletype;
	private Pause pause;
	private Timer timer;
	private Zoom_in zoom_in;
	private Zoom_out zoom_out;
	private Increase_speed inc_speed;
	private Right_panel right;
	private Top_panel top;
	private Left_panel left;
	private Boolean resize = true;
	private Bottom_panel bottom;
	private JFrame new_frame;
    public static void main (String [] args) {
    	java.awt.EventQueue.invokeLater (new Runnable() {
	    	public void run() {
				new Main ();
        	}
    	});
    }

	public Main() {
		setTitle("Submarine warfare");
		setSize(800, 400);
		setLayout(new BorderLayout());
		setBackground(Color.blue.darker().darker());
		// Start timer
		timer = new Timer (100, this); // 100 milliseconds
		timer.start();

		model = new Model();
		intializer();
		
		top = new Top_panel(score);
		add(top, BorderLayout.NORTH);

		left = new Left_panel(move, change_color, add_obstacle);
		add(left, BorderLayout.WEST);

		canvas = new Canvas (model, this);
		add(canvas, BorderLayout.CENTER);

		model.canvas_setter(canvas); // sending a pointer of canvas to model


		right = new Right_panel(night_mode, change_obs_color, 
							new AddObstacleSpec(obstacletype, xc, yc));
		add(right, BorderLayout.EAST);

		Bottom_panel bottom = new Bottom_panel(new Exit("Exit"), pause, 
							  inc_speed, zoom_in, zoom_out);
		add(bottom, BorderLayout.SOUTH);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

    // Like a clock tick
    public void actionPerformed (ActionEvent e) {
		model.change_obstacle_pos(inc_speed.get_speed());
		
		if ((getWidth() <= 400) && resize == true)
		{
			new_frame = new JFrame();
			new_frame.setSize(300, 400);
			new_frame.setLayout(new FlowLayout());
			
			remove(left);
			remove(right);
			new_frame.add(left);
			new_frame.add(right);
			new_frame.setVisible(true);
			resize = false;
		} 
		if ((getWidth() > 450 && resize == false) && new_frame != null) {
			resize = true;
			add(left, BorderLayout.WEST);
			add(right, BorderLayout.EAST);
			new_frame.setVisible(false);
		}
		
		canvas.repaint();
    }

    public void intializer() {
    	score = new Score("SCORE = 0");
    	move = new Move("Submarine position", model);
    	change_color = new Change_color("Change Sub Color", model);
    	add_obstacle = new Add_obstacle("Random obstacle", model);
    	xc = new X_coor();
    	yc = new Y_coor();
    	change_obs_color = new Change_obs_color("obs color", model);
    	night_mode = new Night_mode("Night-mode Off", model);
    	shoot = new Shoot("SHOOT!", model);
    	obstacletype = new ObstacleType (model, xc, yc);
    	pause = new Pause("Pause", model, change_color, shoot, move, timer);
    	inc_speed = new Increase_speed("1X Speed", model);
    	zoom_in = new Zoom_in("Zoom in", model);
    	zoom_out = new Zoom_out("Zoom out", model);
    }
}

