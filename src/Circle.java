import java.awt.*;
import java.awt.event.*;

class Circle extends Point implements MouseListener, MouseMotionListener {   
    private boolean start = true;
    private boolean dragging, pressing;
    private int endX, radius;

    public Circle() {
    }

    public Circle(int x, int y) {
        super(x, y);
    }

    public void draw(Graphics graphics) {
        // Draw circle 
        graphics.drawOval(getX(),getY(),2,2);
        if (start == true) graphics.drawOval(getX()-100, getY()-100,200,200);

        String str;
        str = getX() + "," + getY();
        graphics.drawString(str, getX(), getY() - 10);

        // draw a circle at the same point But when you drag the mouse It increases and decreases in size.
        if (dragging) {
            radius = (int) (endX - getX());
            graphics.drawOval(getX() - radius, getY() - radius, radius * 2, radius * 2);
        } 
        
        // Draw a new point circle.
        if (pressing) {
            graphics.drawOval(getX() - radius, getY() - radius, radius * 2, radius * 2);
        }
    }

    public void mousePressed(MouseEvent pressed) {
        dragging = false;
        pressing = true;
        setX(pressed.getX());
        setY(pressed.getY());
    }

    public void mouseDragged(MouseEvent dragged) {
        dragging = true;
        start = false;
        pressing = false;
        endX = dragged.getX();
    }
    
    // idle
    public void mouseClicked(MouseEvent idle) {}
    public void mouseReleased(MouseEvent idle) {}
    public void mouseEntered(MouseEvent idle) {}
    public void mouseExited(MouseEvent idle) {}
    public void mouseMoved(MouseEvent idle) {}
}