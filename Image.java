import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;

public class Image{
    int radius = 50, img_x = radius + 50, img_y = radius + 50, v_x = 2, v_y = 1;
    int box_w = 800, box_h = 800;
    BufferedImage img;

    public Image(){
        try {
            img = ImageIO.read(new File("longcat.png"));
        } catch (IOException ex) {
            System.out.println("image error");
        }

    }   

    public void flip(String how){
        if (how.equals("up")){
            System.out.println("image flipped vertically");
        }
        else if (how.equals("down")) {
            System.out.println("image flipped vertically");
        }
        else if (how.equals("left")) {
            System.out.println("image flipped horizontally");
            } 
        else if (how.equals("left")) {
            System.out.println("image flipped vertically");
        } else {
        }
    }

    public void bounce(){
        img_x += v_x;
        img_y += v_y;
        if (img_x - radius < 0){
            v_x = -v_x;
            img_x = radius;
        }
        else if (img_x + radius > box_w){
            v_x = -v_x;
            img_x = box_w - radius;
        }
        if (img_y - radius < 0){
            v_y = -v_y;
            img_y = radius;
        }
        else if (img_y + radius > box_h){
            v_y = - v_y;
            img_y = box_h - radius;
        }
        // this.repaint();
    }



    public void paint(Graphics g){
        // g.drawRect(0, 0, box_w, box_h);
        g.setColor(Color.BLACK);
        g.drawImage(img, this.img_x - this.radius, this.img_y - this.radius, null);
    }

}

















// public class Image extends JPanel{

// 	BufferedImage img;
// 	int x = 0;
// 	int direction = 1;

// 	public Image(){
// 		try{
// 	        this.img = ImageIO.read(new File("Longcat.png"));
        
//         } catch (IOException ex){
//         	System.out.println("error");
//         }
//     }

    //  @Override
    // public Dimension getPreferredSize() {
    //     return img == null ? super.getPreferredSize() : new Dimension(img.getWidth() * 4, img.getHeight());
    // }

    // Some code from stackoverflow. Still trying to study this
//     @Override
//     protected void paintComponent(Graphics g) {
//         super.paintComponent(g);
//         int y = getHeight() - img.getHeight();
//         g.drawImage(img, x, y, this);

//     }
// }
