import java.awt.*;
import java.awt.event.*;

class Rectangle extends Point implements MouseListener, MouseMotionListener {
    private int x2 = 600;
    private int y2 = 300;
    private int x3 = 200;
    private int y3 = 500;
    private int x4 = 600;
    private int y4 = 500;

    public Rectangle() {
    }

    public Rectangle(int x, int y, int x2, int y2, int x3, int y3, int x4, int y4) {
        super(x, y);
        this.x2 = x2;
        this.y2 = y2;
        this.x3 = x3;
        this.y3 = y3;
        this.x4 = x4;
        this.y4 = y4;
    }

    public void draw(Graphics graphics) {
        String str,str2,str3,str4;

        // Draw rectangle
        graphics.drawLine(getX(), getY(), getX2(), getY2());
        str = getX() + "," + getY();
        graphics.drawString(str, getX(), getY() - 10);
    
        graphics.drawLine(getX(), getY(), getX3(), getY3());
        str2 = getX2() + "," + getY2();
        graphics.drawString(str2, getX2(), getY2() - 10);
    
        graphics.drawLine(getX2(), getY2(), getX4(), getY4());
        str3 = getX3() + "," + getY3();
        graphics.drawString(str3, getX3(), getY3() + 20);
    
        graphics.drawLine(getX3(), getY3(), getX4(), getY4());
        str4 = getX4() + "," + getY4();
        graphics.drawString(str4, getX4(), getY4() + 20);
    }

    public void mousePressed(MouseEvent pressed) {
        int w,h;
        w = getX2() - getX();
        h = getY3() - getY();
        
        // Draw a new point rectangle.
        setX(pressed.getX());
        setY(pressed.getY());

        setX2(pressed.getX() + w);
        setY2(getY());

        setX3(getX());
        setY3(pressed.getY() + h);

        setX4(getX2());
        setY4(getY3());
    }

    public void mouseDragged(MouseEvent dragged) {
        // draw a rectangle at the same point But when you drag the mouse It increases and decreases in size.
        setX4(dragged.getX());
        setY4(dragged.getY());

        setX2(dragged.getX());
        setY3(dragged.getY());
    }

    public int getX2() {return x2;}
    public void setX2(int x2) {this.x2 = x2;}

    public int getY2() {return y2;}
    public void setY2(int y2) {this.y2 = y2;}

    public int getX3() {return x3;}
    public void setX3(int x3) {this.x3 = x3;}

    public int getY3() {return y3;}
    public void setY3(int y3) {this.y3 = y3;}

    public int getX4() {return x4;}
    public void setX4(int x4) {this.x4 = x4;}

    public int getY4() {return y4;}
    public void setY4(int y4) {this.y4 = y4;}

    // idle
    public void mouseClicked(MouseEvent idle) {}
    public void mouseReleased(MouseEvent idle) {}
    public void mouseEntered(MouseEvent idle) {}
    public void mouseExited(MouseEvent idle) {}
    public void mouseMoved(MouseEvent idle) {}
}