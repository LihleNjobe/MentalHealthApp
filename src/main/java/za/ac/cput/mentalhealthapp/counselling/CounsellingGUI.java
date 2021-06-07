package za.ac.cput.mentalhealthapp.counselling;

import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CounsellingGUI extends JFrame implements ActionListener{
    private JPanel mainPanel;
    private JPanel topPanel;
    private JLabel logoLabel;
    private JPanel centerPanel;
    private JLabel introLabel;
    private JTextPane introText;
    private JButton servicesButton;
    private JButton bookSessionButton;
    private JButton supportGroupsButton;


    public CounsellingGUI(){
        super("Student Counselling");

    }

    public void setGUI(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();
        this.setSize(360, 600);
        this.setVisible(true);


        bookSessionButton.addActionListener(this);
    }

    public static void main(String[] args) {
        new CounsellingGUI().setGUI();
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        //logoLabel = new JLabel(new ImageIcon("images/logo.png"));
        logoLabel = new JLabel();
        ImageIcon logoIcon = new ImageIcon(new ImageIcon("images/logo.png").getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH));
        logoLabel.setIcon(logoIcon);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Book session")){
            JFrame frame = new BookingGUI();
            frame.setVisible(true);
            this.setVisible(false);
        }

    }
}
