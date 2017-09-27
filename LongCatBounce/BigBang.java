import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BigBang extends JComponent implements ActionListener, MouseMotionListener, KeyListener{
	Timer timer;
	World world;
	JButton button1;

	// Use the World interface
	public BigBang(World world){
		this.world = world;
	    this.addMouseMotionListener(this); 
    	this.addKeyListener(this); 
	    this.setFocusable(true); 
	    this.requestFocus();
	}

	// Set the frame
	public void start(int delay, int size){
		JFrame frame = new JFrame();
		frame.add(this);
		frame.setVisible(true);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setSize(size, size);
	    frame.getContentPane().setBackground( Color.cyan );

	    // Bound the button to action event
	    this.button1 = new JButton("More cats!");
	    button1.setBounds(300, 20, 100, 30);
	    this.add(button1);
	    button1.addActionListener(this);

        this.timer = new Timer(delay, this);  
	    this.timer.start(); 
	}

	public void mouseMoved(MouseEvent e){ }
	public void mouseDragged(MouseEvent e){ }

	public void keyReleased(KeyEvent e) { }  
	public void keyTyped(KeyEvent e) { }
	public void keyPressed(KeyEvent e) {}

	// Action to perform
	public void actionPerformed(ActionEvent e){
		this.world.time_pass();
		this.repaint();
		if (e.getSource() == button1){
			this.world.but_opr(e);
		}
	}

	public void paintComponent(Graphics g){
		this.world.draw(g);
	}
}


