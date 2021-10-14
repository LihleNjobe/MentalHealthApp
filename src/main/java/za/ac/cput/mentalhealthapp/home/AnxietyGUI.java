package za.ac.cput.mentalhealthapp.home;

import za.ac.cput.mentalhealthapp.counselling.GUIs.CounsellingGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AnxietyGUI extends JFrame implements ActionListener {
    private JPanel mainPanel;
    private JButton back;
    private JTextArea aMentalHealthDisorderTextArea;
    private JTextArea nervousnessRestlessnessFeelingOfTextArea;
    private JTextArea identifyAndLearnToTextArea;
    private JTextField textField1;
    private JPanel panelNorth;
    private JLabel picLabel;
    private JButton studentCounsellingButton;

    public AnxietyGUI() {
        super("Anxiety");

    }

    public void setGUI() {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setSize(360, 650);
        this.setContentPane(mainPanel);
        this.setVisible(true);
        studentCounsellingButton.addActionListener(this);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here

        picLabel = new JLabel();
        ImageIcon icon = new ImageIcon(new ImageIcon("images/anxiety.jpg").getImage().getScaledInstance(300, 150, Image.SCALE_SMOOTH));
        picLabel.setIcon(icon);

    }


    public static void main(String[] args) {
        new AnxietyGUI().setGUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Student Counselling ")) {



            JFrame frame = new CounsellingGUI();
            new CounsellingGUI().setGUI();

            this.setVisible(false);

        }


    }
}