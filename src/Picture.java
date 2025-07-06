import java.awt.*;
import javax.swing.*;
import java.util.Random;

class Picture extends Point {
    private Random random = new Random();
    private ImageIcon[] ufo = new ImageIcon[10];
    private int[] x = new int[10];
    private int[] y = new int[10];
    private int[] xSpeed = new int[10];
    private int[] ySpeed = new int[10];
    private int sizeX = 72, sizeY = 50;
    private int width = 1180, height = 600;
    
    public Picture() {
        // random x , y , xSpeed , ySpeed
        for (int n = 0 ; n < 10 ; n++) {
            x[n] = random.nextInt(1000) + 20;
            y[n] = random.nextInt(500) + 20;
            xSpeed[n] = random.nextInt(6) + 1;
            ySpeed[n] = random.nextInt(6) + 1;
        } 
    }

    public void draw(Graphics graphics) {
        // Draw ufo 10 ships
        for (int n = 0 ; n < 10 ; n++) {
            ufo[n] = new ImageIcon("lib/ufo.png");
            ufo[n].paintIcon(null, graphics, x[n], y[n]);
        }
    }

    public void move() {
        // set the ufo to move
        for (int n = 0 ; n < 5 ; n++) { // Run right 5 ships
            x[n] += xSpeed[n];
            y[n] += ySpeed[n];
            if (x[n] < 1) xSpeed[n] = -xSpeed[n];
            else if (x[n] + sizeX > width) xSpeed[n] = -xSpeed[n];
            if (y[n] < 1) ySpeed[n] = -ySpeed[n];
            else if (y[n] + sizeY > height) ySpeed[n] = -ySpeed[n];
        } 
        for (int n = 5 ; n < 10 ; n++) { // Run left 5 ships
            x[n] -= xSpeed[n];
            y[n] -= ySpeed[n];
            if (x[n] < 1) xSpeed[n] = -xSpeed[n];
            else if (x[n] + sizeX > width) xSpeed[n] = -xSpeed[n];
            if (y[n] < 1) ySpeed[n] = -ySpeed[n];
            else if (y[n] + sizeY > height) ySpeed[n] = -ySpeed[n];
        }
    }
}