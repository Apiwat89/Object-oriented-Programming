import java.awt.*;
import java.awt.event.*;

class Triangle extends Point implements MouseListener, MouseMotionListener {
    private int x2=75 , y2=400;
    private int x3=325 , y3=400;

    public Triangle() {
    }

    public Triangle(int x, int y, int x2, int y2, int x3, int y3) {
        super(x, y);
        this.x2 = x2;
        this.y2 = y2;
        this.x3 = x3;
        this.y3 = y3;
    }

    public void draw(Graphics graphics) {
        String str,str2,str3;

        // Draw Triangle
        graphics.drawLine(getX(),getY(),getX2(),getY2());
        str = getX() + "," + getY();
        graphics.drawString(str, getX(), getY() - 10);

        graphics.drawLine(getX(),getY(),getX3(),getY3());
        str2 = getX2() + "," + getY2();
        graphics.drawString(str2, getX2(), getY2() + 20);

        graphics.drawLine(getX2(),getY2(),getX3(),getY3());
        str3 = getX3() + "," + getY3();
        graphics.drawString(str3, getX3(), getY3() + 20);
    }

    public void mousePressed(MouseEvent pressed) {
        int x,y;
        x = getX() - getX2();
        y = getY2() - getY();
       
        // Draw a new point triangle.
        setX(pressed.getX());
        setY(pressed.getY());

        setX2(getX() - x);
        setY2(getY() + y);

        setX3(getX() + x);
        setY3(getY2());
    }

    public void mouseDragged(MouseEvent dragged) {
        // draw a triangle at the same point But when you drag the mouse It increases and decreases in size.
        setX2(dragged.getX());
        setY2(dragged.getY());

        setX3((getX() - dragged.getX()) + getX());
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
    
    // idle
    public void mouseClicked(MouseEvent idle) {}
    public void mouseReleased(MouseEvent idle) {}
    public void mouseEntered(MouseEvent idle) {}
    public void mouseExited(MouseEvent idle) {}
    public void mouseMoved(MouseEvent idle) {}
}