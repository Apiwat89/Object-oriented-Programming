import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Project extends JFrame implements ActionListener {
    private Container container; 
    private GraphicsPanel graphicsPanel;
    
    private JPanel buttonPanel, valuePanel;
    private JButton[] button = new JButton[12];
    private JRadioButton[] radiobutton = new JRadioButton[4];
    private ButtonGroup buttongroup;
    private ImageIcon ufoIcon;

    public static void main(String args[]) {new Project();}
    
    public Project() {
        super("Project : 060243104 Object-oriented Programming");
        container = getContentPane();
        container.setLayout(new FlowLayout());

        graphicsPanel = new GraphicsPanel();
        ufoIcon = new ImageIcon("lib/ufo.png");

        var check = JOptionPane.showConfirmDialog(null,"Do you want to use the project?","project",1,EXIT_ON_CLOSE,ufoIcon);
        
        if (check == 0) {
            button_Panel();
            container.add(graphicsPanel);
            value_Panel();
            this.setVisible(true);
        } else if (check == 1) {
            JOptionPane.showMessageDialog(null,"You don't want to use the project.","project",JOptionPane.NO_OPTION);
            System.exit(0);
        } else if (check == 2) System.exit(0);

        this.setSize(1200,750);
        this.setLocation(160,30);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void button_Panel() {
        buttonPanel = new JPanel();
        buttonPanel.setPreferredSize(new Dimension(1180,45));
        buttonPanel.setBorder(BorderFactory.createLineBorder(Color.gray,1));
        buttonPanel.setBackground(Color.lightGray);

        String[] textbutton = {"Triangle","Square","Rectangle","Circle","Red","Green",
        "Blue","Magenta","Picture","Play","Stop","Exit"};

        for (int n = 0 ; n < 12 ; n++) {
            button[n] = new JButton(textbutton[n]);
            button[n].setFont(new Font("SERIF",Font.BOLD,17));
            button[n].addActionListener(this);

            JLabel empty = new JLabel("   |   ");
            empty.setFont(new Font("SERIF",Font.BOLD,20));
            
            if (n == 4) buttonPanel.add(empty);
            else if (n == 8) buttonPanel.add(empty);
            else if (n == 11) buttonPanel.add(empty);

            buttonPanel.add(button[n]);
        }

        container.add(buttonPanel);
    }

    private void value_Panel() {
        valuePanel = new JPanel();
        valuePanel.setPreferredSize(new Dimension(1180,35));
        valuePanel.setBorder(BorderFactory.createLineBorder(Color.gray,1));
        valuePanel.setBackground(Color.lightGray);

        String[] textradiobutton = {"Bright","Dark","Orange","Pink"};

        for (int n = 0 ; n < 4 ; n++) {
            radiobutton[n] = new JRadioButton(textradiobutton[n]);
            radiobutton[n].setBackground(Color.lightGray);
            radiobutton[n].addActionListener(this);

            buttongroup = new ButtonGroup();
            buttongroup.add(radiobutton[0]);
            buttongroup.add(radiobutton[1]);
            buttongroup.add(radiobutton[2]);
            buttongroup.add(radiobutton[3]);

            valuePanel.add(radiobutton[n]);
        }

        container.add(valuePanel);
    }

    private void check_Action(ActionEvent e) {
        // Button Shape in button_Panel
        if (e.getSource() == button[0]) graphicsPanel.setTextShape("Triangle");
        if (e.getSource() == button[1]) graphicsPanel.setTextShape("Square");
        if (e.getSource() == button[2]) graphicsPanel.setTextShape("Rectangle");
        if (e.getSource() == button[3]) graphicsPanel.setTextShape("Circle");
        if (e.getSource() == button[8]) graphicsPanel.setTextShape("Picture");

        // Button Color in button_Panel
        if (e.getSource() == button[4]) graphicsPanel.setTextColor("Red");
        if (e.getSource() == button[5]) graphicsPanel.setTextColor("Green");
        if (e.getSource() == button[6]) graphicsPanel.setTextColor("Blue");
        if (e.getSource() == button[7]) graphicsPanel.setTextColor("Magenta");

        // Button Play,Stop in button_Panel
        if (e.getSource() == button[9]) graphicsPanel.setTextPS("Play");
        if (e.getSource() == button[10]) graphicsPanel.setTextPS("Stop");
         
        // Button Exit in button_Panel
        if (e.getSource() == button[11]) {
            JOptionPane.showMessageDialog(null,"Thank you for using","project",EXIT_ON_CLOSE,ufoIcon);
            System.exit(0);
        }

        // RadioButton Mode in value_Panel
        if (radiobutton[0].isSelected() == true) graphicsPanel.setTextMode("Bright");
        if (radiobutton[1].isSelected() == true) graphicsPanel.setTextMode("Dark");
        if (radiobutton[2].isSelected() == true) graphicsPanel.setTextMode("Orange");
        if (radiobutton[3].isSelected() == true) graphicsPanel.setTextMode("Pink");
        repaint();
    }

    private void check_Paint() {
        // Set a color for the default button.
        for (int n = 0 ; n < 11 ; n++) button[n].setBackground(Color.orange);

        // Button Shape in button_Panel
        if (graphicsPanel.getTextShape() == "Triangle") button[0].setBackground(Color.green);
        if (graphicsPanel.getTextShape() == "Square") button[1].setBackground(Color.green);
        if (graphicsPanel.getTextShape() == "Rectangle") button[2].setBackground(Color.green);
        if (graphicsPanel.getTextShape() == "Circle") button[3].setBackground(Color.green);
        if (graphicsPanel.getTextShape() == "Picture") button[8].setBackground(Color.green);

        // Button Color in button_Panel
        if (graphicsPanel.getTextColor() == "Red") button[4].setBackground(Color.green);
        if (graphicsPanel.getTextColor() == "Green") button[5].setBackground(Color.green);
        if (graphicsPanel.getTextColor() == "Blue") button[6].setBackground(Color.green);
        if (graphicsPanel.getTextColor() == "Magenta") button[7].setBackground(Color.green);

        // Button Play,Stop in button_Panel
        if (graphicsPanel.getTextPS() == "Play") button[9].setBackground(Color.yellow);
        if (graphicsPanel.getTextPS() == "Stop") button[9].setBackground(Color.orange);

        // Button Exit in button_Panel
        button[11].setForeground(Color.white);
        button[11].setBackground(Color.red);

        // Message Shap,Color in value_Panel
        Graphics g = valuePanel.getGraphics();
        g.setFont(new Font("SERIF",Font.PLAIN,18));
        g.drawString("Shap : " + graphicsPanel.getTextShape(), 10, 25);
        g.drawString("Color : " + graphicsPanel.getTextColor(), 1050, 25);
    }

    @Override // main paint checker
    public void paint(Graphics graphics) {
        super.paint(graphics);
        check_Paint();
    }

    @Override // main actionPerformed checker
    public void actionPerformed(ActionEvent action) {
        check_Action(action);
        repaint();
    }
}