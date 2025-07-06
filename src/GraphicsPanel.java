import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class GraphicsPanel extends JPanel implements ActionListener, MouseListener, MouseMotionListener {
    private Triangle triangle;
    private Rectangle rectangle;
    private Square square;
    private Circle circle;
    private Picture picture;

    private Timer animation;
    private int X_pos, Y_pos;
    private String textShape = "null";
    private String textColor, textPS, textMode;

    public GraphicsPanel() {
        picture = new Picture();
        rectangle = new Rectangle();
        triangle = new Triangle();
        square = new Square();
        circle = new Circle();

        animation = new Timer(30,this);
        addMouseListener(this);
        addMouseMotionListener(this);

        this.setPreferredSize(new Dimension(1180,613));
        this.setBorder(BorderFactory.createLineBorder(Color.gray,1));
    }

    private void pos_Draw(Graphics g) {
        String pos; // Draw Pos
        pos = "[ x " + X_pos + " , y " + Y_pos + " ]";
        g.setFont(new Font("SERIF",Font.PLAIN,15));
        g.drawString(pos, 15, 25);
    }

    @Override // main mouseMoved checker
    public void mouseMoved(MouseEvent moved) {
        X_pos = moved.getX();
        Y_pos = moved.getY();
        repaint();
    }

    private void step1_Draw(Graphics g) {
        // Draw Shape
        if (textShape == "null") {
            g.setFont(new Font("MONOSPACED",Font.HANGING_BASELINE,50));
            g.drawString("Please select a shape",260,300);
        }
        if (textShape == "Triangle") {
            triangle.draw(g); 
            textPS = "Stop";
        }
        if (textShape == "Square") {
            square.draw(g); 
            textPS = "Stop";
        }
        if (textShape == "Rectangle") {
            rectangle.draw(g);
            textPS = "Stop";
        }
        if (textShape == "Circle") {
            circle.draw(g); 
            textPS = "Stop";
        }
        if (textShape == "Picture") picture.draw(g);

        // animation
        if (textPS == "Play") animation.start();
        if (textPS == "Stop") animation.stop();
    }

    private void step2_Paint(Graphics g) {
        // step2_Paint gets shape1_Paint and pos_Draw into work.
        pos_Draw(g);
        step1_Draw(g);

        // Draw Color
        if (textColor == "Red") {
            g.setColor(Color.red);
            step1_Draw(g);
        } 
        if (textColor == "Green") {
            g.setColor(Color.green);
            step1_Draw(g);
        } 
        if (textColor == "Blue") {
            g.setColor(Color.blue);
            step1_Draw(g);
        } 
        if (textColor == "Magenta") {
            g.setColor(Color.magenta);
            step1_Draw(g);
        }

        // Draw screen color
        if (textMode == "Bright") this.setBackground(Color.white);
        if (textMode == "Dark") this.setBackground(Color.lightGray);
        if (textMode == "Orange") this.setBackground(Color.orange);
        if (textMode == "Pink") this.setBackground(Color.pink);
    }

    @Override // main paintComponent checker
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        step2_Paint(graphics);
    }

    @Override // main actionPerformed checker
    public void actionPerformed(ActionEvent action) {
        picture.move(); // call method move from class picture
        repaint();
    }

    @Override // main mousePressed checker
    public void mousePressed(MouseEvent pressed) {
        if (textShape == "Triangle") triangle.mousePressed(pressed);
        if (textShape == "Rectangle") rectangle.mousePressed(pressed);
        if (textShape == "Square") square.mousePressed(pressed);
        if (textShape == "Circle") circle.mousePressed(pressed);
        repaint();
    }

    @Override // main mouseDragged checker
    public void mouseDragged(MouseEvent dragged) {
        if (textShape == "Triangle") triangle.mouseDragged(dragged);
        if (textShape == "Rectangle") rectangle.mouseDragged(dragged);
        if (textShape == "Square") square.mouseDragged(dragged);
        if (textShape == "Circle") circle.mouseDragged(dragged);
        repaint();
    }

    @Override // main mouseReleased checker
    public void mouseReleased(MouseEvent Released) {
        if (textShape == "Square") square.mouseReleased(Released);
        repaint();
    }

    // Set a string at the project class.
    public void setTextShape(String textShape) {this.textShape = textShape;}
    public String getTextShape() {return this.textShape;}

    public void setTextColor(String textColor) {this.textColor = textColor;}
    public String getTextColor() {return this.textColor;}

    public void setTextPS(String textPS) {this.textPS = textPS;}
    public String getTextPS() {return this.textPS;}

    public void setTextMode(String textMode) {this.textMode = textMode;}

    // idle
    public void mouseClicked(MouseEvent idle) {}
    public void mouseEntered(MouseEvent idle) {}
    public void mouseExited(MouseEvent idle) {}
}