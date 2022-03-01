import javax.swing.*;
import javax.swing.ImageIcon;
import javax.swing.Timer;
import java.awt.event.*;

public class Lab05Demo {
    private JPanel clockPanel;
    private JLabel digitLabel;
    private JTextField digitTextField;
    private JButton startButton;
    private JButton stopButton;
    private JButton resetButton;
    private ImageIcon[] digitIcon;
    private int counter = 0;
    private String[] digitString = {"ZERO", "ONE", "TWO", "THREE", "FOUR", "FIVE", "SIX", "SEVEN", "EIGHT", "NINE"};
    private Timer clock;

    public Lab05Demo() {
        // read in the nixie tube digits
        digitIcon = new ImageIcon[ 10 ];
        for ( int i = 0; i < 10; i++ ) {

            // generate the filename for the image of each digit
            String filename = "/images/nix" + i + ".gif";

            // the following code is used to safely load a resource file containing a digit image
            // and then store that digit in the array under the appropriate index.
            //   this          - references the instantiation of this frame
            //   getClass      - given an object, gets the name of its class,
            //                   returns an object of type java.lang.Class
            //   getResource() - returns a URL that represents a resource file,
            //                   which can then be used to access that resource.
            digitIcon[i] = new ImageIcon( this.getClass().getResource(filename) );
        }
        digitLabel.setIcon(digitIcon[0]);

        digitTextField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        digitTextField.setOpaque(false);
        digitTextField.setText(digitString[0]);

        clock = new javax.swing.Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                clockActionPerformed(evt);
            }
        });

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clock.start();
            }
        });
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clock.stop();
                counter = 0;
                digitLabel.setIcon(digitIcon[counter]);
                digitTextField.setText(digitString[counter]);
            }
        });
        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clock.stop();
            }
        });
    }

    public void clockActionPerformed(ActionEvent evt){
        counter = (counter + 1) % 10;
        digitLabel.setIcon(digitIcon[counter]);
        digitTextField.setText(digitString[counter]);
    }

    public static void main(String[] args) {
        JFrame myFrame = new JFrame("Lab 05 Demo");
        myFrame.setContentPane(new Lab05Demo().clockPanel);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.pack();
        myFrame.setVisible(true);
    }
}


