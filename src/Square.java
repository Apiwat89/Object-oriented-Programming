import java.awt.*;
import java.awt.event.*;

class Square extends Point implements MouseListener, MouseMotionListener {
    private int oldX = 0;
    private boolean start = true;
    private int x2=350,y2=300;
    private int x3=200,y3=450;
    private int x4=350,y4=450;

    public Square() {
    }

    public Square(int x, int y, int x2, int y2, int x3, int y3, int x4, int y4) {
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

        // Draw square
        graphics.drawLine(getX(),getY(),getX2(),getY2());
        str = getX() + "," + getY();
        graphics.drawString(str, getX(), getY() - 10);

        graphics.drawLine(getX(),getY(),getX3(),getY3());
        str2 = getX2() + "," + getY2();
        graphics.drawString(str2, getX2(), getY2() - 10);

        graphics.drawLine(getX2(),getY2(),getX4(),getY4());
        str3 = getX3() + "," + getY3();
        graphics.drawString(str3, getX3(), getY3() + 20);

        graphics.drawLine(getX4(),getY4(),getX3(),getY3());
        str4 = getX4() + "," + getY4();
        graphics.drawString(str4, getX4(), getY4() + 20);
    }

    public void mousePressed(MouseEvent pressed) {
        int n;
        n = getX2() - getX();

        // Draw a new point square.
        setX(pressed.getX());
        setY(pressed.getY());

        setX2(getX() + n);
        setY2(pressed.getY());

        setX3(pressed.getX());
        setY3(pressed.getY() + n);

        setX4(getX2());
        setY4(getY3());
    }

    public void mouseDragged(MouseEvent dragged) {
        // draw a square at the same point But when you drag the mouse It increases and decreases in size.
        if(start == true) {
            setX2(getX());
            setY2(getY());

            setX3(getX());
            setY3(getY());

            setX4(getX());
            setY4(getY());
        }
        if (oldX < dragged.getX()) {
            setX2(getX2() + 2);
            setY3(getY3() + 2);

            setX4(getX4() + 2);
            setY4(getY4() + 2);
        }
        else if (oldX > dragged.getX()) {
            setX2(getX2() - 2);
            setY3(getY3() - 2);

            setX4(getX4() - 2);
            setY4(getY4() - 2);
        }
        oldX = dragged.getX();
        start = false;
    }

    public void mouseReleased(MouseEvent Released) {
        // Reset drawing when mouse is released
        start = true;
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
    public void mouseEntered(MouseEvent idle) {}
    public void mouseExited(MouseEvent idle) {}
    public void mouseMoved(MouseEvent idle) {}
}