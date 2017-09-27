/* A cat bouncing game inspired by: http://cat-bounce.com/mobile/index.html

Features: 
1. When the game starts, the cat should bounce around.
2. Click the button to make more cats appear on the screen.*/


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;


public class Game implements World{
	// An arraylist to hold the cats
	ArrayList<Image> img_list = new ArrayList<Image>();
	Image img;

    // Initial cat
	public Game(){
		img_list.add(new Image());
	}

	public void time_pass(){
		for (Image img: this.img_list){
			img.bounce();
		}
	}

	// When button is pushed, add a new cat object
	public void but_opr(ActionEvent e){
		this.img_list.add(new Image());
	}

	public void draw(Graphics g){
		for (Image img: this.img_list){
			img.paint(g);
	}
}
	public void mouse_opr(MouseEvent e){}

	public void key_opr(KeyEvent e){}

	public static void main(String[] args){
		BigBang b = new BigBang(new Game());
		b.start(20, 800);
	}

}