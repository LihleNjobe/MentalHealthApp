package za.ac.cput.mentalhealthapp.counselling.GUIs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SupportGroupsGUI extends JFrame {

    private JPanel mainPanel;
    private JPanel topPanel;
    private JButton button1;
    private JLabel txtHeading1;
    private JPanel centerPanel;
    private JTextArea TextArea;
    private JTextArea groups;
    private JLabel heading2;
    private JLabel heading3;

    public SupportGroupsGUI(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();
        this.setSize(360, 600);
        this.setVisible(true);

        TextArea.setBorder(BorderFactory.createCompoundBorder(
                centerPanel.getBorder(),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));

        TextArea.setForeground(Color.WHITE);

        txtHeading1.setForeground(Color.WHITE);

        groups.setBorder(BorderFactory.createCompoundBorder(
                centerPanel.getBorder(),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));

        groups.setForeground(Color.WHITE);

        heading2.setForeground(Color.WHITE);

        heading3.setForeground(Color.WHITE);

        button1.setForeground(Color.WHITE);


        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SadagGUI().setupUI();
            }
        });
    }

    public static void main(String[] args) {
        new SupportGroupsGUI();
    }

}
