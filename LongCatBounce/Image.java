// to implement:

import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.event.*;

import java.util.Random;

public class Image{
    int radius = 50, img_x = radius + 50, img_y = radius + 50;
    int v_x = 10, v_y = 8;
    int box_w = 800, box_h = 800;
    BufferedImage img;

    // Read image from file.
    public Image(){
        try {
            img = ImageIO.read(new File("longcat.png"));
        } catch (IOException ex) {
            System.out.println("image error");
        }

    }   


    // bounce: the cat bounces when it reaches box borders.
    // velocity reduce and finally it will stop.
    public void bounce(){
        // so that not all cats move in the same trajectory
        Random rand = new Random();
        int offset = rand.nextInt(2);
        img_x += v_x;
        img_y += v_y;
        if (img_x - radius < 0){
            if (v_x > 0){
                v_x = -v_x + offset ;
            }
            else if (v_x < 0){
                v_x = -v_x - offset;
            }
            img_x = radius;
        }
        else if (img_x + radius > box_w){
            if (v_x > 0){
                v_x = -v_x + offset;
            }
            else if (v_x < 0){
                v_x = -v_x - offset;
            }
            img_x = box_w - radius;
        }
        if (img_y - radius < 0){
            if (v_y > 0){
                v_y = -v_y + offset;
            }
            else if (v_y < 0){
                v_y = -v_y - offset;
            }            
            img_y = radius;
        }
        else if (img_y + radius > box_h){
            if (v_y > 0){
                v_y = -v_y + offset;
            }
            else if (v_y < 0){
                v_y = -v_y - offset;
            }
            img_y = box_h - radius;
        }
    }


    public void paint(Graphics g){
        g.setColor(Color.BLACK);
        g.drawImage(img, this.img_x - this.radius, this.img_y - this.radius, null);
    }
}

