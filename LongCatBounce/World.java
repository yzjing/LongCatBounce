import java.awt.Graphics;
import java.awt.event.*;

interface World{
	void draw(Graphics g);
	void time_pass();
	void but_opr(ActionEvent e);
}