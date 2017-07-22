import java.awt.Graphics;
import java.awt.event.KeyEvent; 
import java.awt.event.MouseEvent; 

interface World{
	void draw(Graphics g);
	void time_pass();
	void mouse_opr(MouseEvent e);
	void key_opr(KeyEvent e);
}