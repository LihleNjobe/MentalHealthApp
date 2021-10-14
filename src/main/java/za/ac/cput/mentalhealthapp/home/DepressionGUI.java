package za.ac.cput.mentalhealthapp.home;

import javax.swing.*;
import java.awt.*;

public class DepressionGUI extends JFrame {
    private JPanel mainPanel;
    private JPanel panelNorth;
    private JButton back;
    private JTextField textField1;
    private JLabel picLabel;
    private JTextArea aMentalHealthDisorderTextArea;
    private JTextArea nervousnessRestlessnessFeelingOfTextArea;
    private JTextArea identifyAndLearnToTextArea;



    public DepressionGUI() {
        super("Depression");

    }

    public void setGUI() {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setSize(360, 650);
        this.setContentPane(mainPanel);
        this.setVisible(true);

    }

    private void createUIComponents() {
        // TODO: place custom component creation code here

        picLabel = new JLabel();
        ImageIcon icon = new ImageIcon(new ImageIcon("images/depression.png").getImage().getScaledInstance(300, 150, Image.SCALE_SMOOTH));
        picLabel.setIcon(icon);

    }


    public static void main(String[] args) {
        new DepressionGUI().setGUI();
    }





}


