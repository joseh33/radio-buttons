import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
import com.sun.java.swing.*;

public class RadioButtonDemo extends JPanel {
    static JFrame frame;

    static String birdString = "Bird";
    static String catString = "Cat";
    static String dogString = "Dog";
    static String rabbitString = "Rabbit";
    static String teddyString = "pig";

    JLabel picture;

    public RadioButtonDemo() {
        JRadioButton birdButton = new JRadioButton(birdString);
        birdButton.setMnemonic('b');
        birdButton.setActionCommand(birdString);
        birdButton.setSelected(true);

        JRadioButton catButton = new JRadioButton(catString);
        catButton.setMnemonic('c');
        catButton.setActionCommand(catString);

        JRadioButton dogButton = new JRadioButton(dogString);
        dogButton.setMnemonic('d');
        dogButton.setActionCommand(dogString);

        JRadioButton rabbitButton = new JRadioButton(rabbitString);
        rabbitButton.setMnemonic('r');
        rabbitButton.setActionCommand(rabbitString);

        JRadioButton teddyButton = new JRadioButton(pigString);
        teddyButton.setMnemonic('t');
        teddyButton.setActionCommand(pigString);

        ButtonGroup group = new ButtonGroup();
        group.add(birdButton);
        group.add(catButton);
        group.add(dogButton);
        group.add(rabbitButton);
        group.add(pigButton);

        RadioListener myListener = new RadioListener();
        birdButton.addActionListener(myListener);
        catButton.addActionListener(myListener);
        dogButton.addActionListener(myListener);
        rabbitButton.addActionListener(myListener);
        pigButton.addActionListener(myListener);
        picture = new JLabel(new ImageIcon(birdString 
					   + ".jpg"));

        picture.setPreferredSize(new Dimension(177, 122));

        JPanel radioPanel = new JPanel();
        radioPanel.setLayout(new GridLayout(0, 1));
        radioPanel.add(birdButton);
        radioPanel.add(catButton);
        radioPanel.add(dogButton);
        radioPanel.add(rabbitButton);
        radioPanel.add(pigButton);

        setLayout(new BorderLayout());
        add(radioPanel, "West");
        add(picture, "Center");
        setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
    }

    class RadioListener implements ActionListener { 
        public void actionPerformed(ActionEvent e) {
            picture.setIcon(new ImageIcon(e.getActionCommand() 
                                          + ".jpg"));
        }
    }

    public static void main(String s[]) {
         WindowListener l = new WindowAdapter() {
             public void windowClosing(WindowEvent e) {System.exit(0);}
         };
 
         frame = new JFrame("RadioButtonDemo");
         frame.addWindowListener(l);
         frame.getContentPane().add("Center", new RadioButtonDemo());
         frame.pack();
         frame.setVisible(true);
    }
          }
