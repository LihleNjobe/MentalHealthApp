package za.ac.cput.mentalhealthapp.counselling.GUIs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SadagGUI extends JFrame implements ActionListener {
    private JPanel mainPanel;
    private JPanel topPanel;
    private JButton button1;
    private JLabel txtHeading1;
    private JPanel iconPanel;
    private JLabel logoLabel;
    private JScrollPane scrollPanel;
    private JPanel imageSlide;
    private JLabel imageLabel;
    private JButton backButton;
    private JButton nextButton;
    private JButton aboutButton;
    private JButton getInTouchButton;
    ImageIcon s[];
    int i;

    public SadagGUI(){
        super("SADAG");
        s = new ImageIcon[4];

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CounsellingGUI().setGUI();
            }
        });
        aboutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SupportGroupsGUI();
            }
        });
    }

    public void setupUI(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        txtHeading1.setForeground(Color.WHITE);
        button1.setForeground(Color.WHITE);
        backButton.setForeground(Color.WHITE);
        nextButton.setForeground(Color.WHITE);

//        supportGroupsButton.setForeground(Color.WHITE);
//        websiteButton.setForeground(Color.WHITE);
//        aboutButton.setForeground(Color.WHITE);

        backButton.addActionListener(this);
        nextButton.addActionListener(this);
        this.pack();
        this.setSize(360, 600);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new SadagGUI().setupUI();
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        logoLabel = new JLabel();
        ImageIcon logoIcon = new ImageIcon(new ImageIcon("images/SADAG_logo.png").getImage().
                getScaledInstance(120, 120, Image.SCALE_SMOOTH));
        logoLabel.setIcon(logoIcon);


        imageLabel = new JLabel();


        s[0] = new ImageIcon(new ImageIcon("images/slide1.PNG").getImage().
                getScaledInstance(240, 370, Image.SCALE_SMOOTH));
        imageLabel.setIcon(s[0]);

        s[1] = new ImageIcon(new ImageIcon("images/slide2.PNG").getImage().
                getScaledInstance(240, 370, Image.SCALE_SMOOTH));

        s[2] = new ImageIcon(new ImageIcon("images/slide3.jpg").getImage().
                getScaledInstance(240, 370, Image.SCALE_SMOOTH));

        s[3] = new ImageIcon(new ImageIcon("images/slide4.jpg").getImage().
                getScaledInstance(240, 370, Image.SCALE_SMOOTH));

    }

    @Override
    public void actionPerformed(ActionEvent e) {

                if(e.getSource()==nextButton){

                    //imageLabel.setIcon(s[1]);

                    if(i==0)
                    {
                        i++;
                        imageLabel.setIcon(s[1]);


                    }
                    else if(i == 1)
                    {
                        i++;
                        imageLabel.setIcon(s[1]);


                    }
                    else if(i == 2)
                    {
                        i++;
                        imageLabel.setIcon(s[2]);

                    }
                    else if(i == 3)
                    {
                        i++;
                        imageLabel.setIcon(s[3]);

                    }



                }
                else if(e.getSource()==backButton){
                    if(i==s.length-1)
                    {
                        JOptionPane.showMessageDialog(null,"This is LastImage");
                    }
                    else
                    {
                        i=i+1;
                        imageLabel.setIcon(s[i]);
                    }
                }

                }


    }

