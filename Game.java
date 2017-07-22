// I'd like to make a cat bouncing game (refering to this: http://cat-bounce.com/mobile/index.html)
// When the game starts, the cat should bounce around.
// Mouse dragging allows the cat to be dragged.
// Pressing arrow keys allow the cat to change direction that it faces.


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Game implements World{
	Image img;

	public Game(){
		this.img = new Image();
	}

	public void time_pass(){
		this.img.bounce();
		// System.out.println("Cat should bounce" );
	}

	public void mouse_opr(MouseEvent e){
		System.out.println("This should drag the cat around");
	}

	public void key_opr(KeyEvent e){
		int code = e.getKeyCode();
		if (code == 37) {
			this.img.flip("left");
		}
		else if (code == 38) {
			this.img.flip("up");
		}
		else if (code == 39){
			this.img.flip("right");
		}
		else if (code == 40){
			this.img.flip("down");
		}
		else{}
	}

	public void draw(Graphics g){
		this.img.paint(g);
	}

	public static void main(String[] args){
		BigBang b = new BigBang(new Game());
		b.start(10, 800);
	}

}