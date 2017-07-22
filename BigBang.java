import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BigBang extends JComponent implements ActionListener, MouseMotionListener, KeyListener{
	Timer timer;
	World world;

	public BigBang(World world){
		this.world = world;
	    this.addMouseMotionListener(this); 
    	this.addKeyListener(this); 
	    this.setFocusable(true); 
	    this.requestFocus();
	}

	public void start(int delay, int size){
		JFrame frame = new JFrame();
		frame.add(this);
		frame.setVisible(true);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setSize(size, size);
	    // frame.add(new Image());
        this.timer = new Timer(delay, this);  
	    this.timer.start(); 
	}

	public void mouseMoved(MouseEvent e){
	}

	public void mouseDragged(MouseEvent e){
	    this.world.mouse_opr(e); 
	    this.repaint();
	}

	public void keyReleased(KeyEvent e) { }  
	public void keyTyped(KeyEvent e) { }
	 
	public void keyPressed(KeyEvent e) {
	    this.world.key_opr(e);
	    this.repaint();
	}

	public void actionPerformed(ActionEvent e){
		this.world.time_pass();
		this.repaint();
	}

	public void paintComponent(Graphics g){
		this.world.draw(g);
	}
}


