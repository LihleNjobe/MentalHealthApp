/*
*This is a symptoms checker file, where the user will click their current symptoms on the radio button beside
each symptom
* @Author: Lihle Njobe- 218193882
* Due date: 07 June 2021
 */
package za.ac.cput.mentalhealthapp;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SymptomsChecker extends JFrame implements ActionListener {

    private JPanel panelNorth;
    private JPanel panelCenter, panelRB1, panelRB2;
    private JPanel panelSouth;
    private JLabel lblHeading;


    private JLabel lblFatigue;
    private JRadioButton radFatigueYes;

    private JLabel lblAppetite;
    private JRadioButton radAppetiteYes;

    private JLabel lblInterest;
    private JRadioButton radInterestYes;

    private JLabel lblAnger;
    private JRadioButton radAngerYes;


    private JLabel lblNervous;
    private JRadioButton radNervousYes;

    private JLabel lblDanger;
    private JRadioButton radDangerYes;


    private JLabel lblHeartRate;
    private JRadioButton radHeartRateYes;

    private JLabel lblHeavySweating;
    private JRadioButton radHeavySweatingYes;



    private JButton btnSubmit;
    private Font ft1, ft2, ft3;

    public SymptomsChecker() {
        panelNorth = new JPanel();
        panelCenter = new JPanel();
        panelRB1 = new JPanel();
        panelRB2 = new JPanel();
        panelSouth = new JPanel();

        lblHeading = new JLabel(" Symptoms Checker ");

        lblFatigue = new JLabel("Increased fatigue and sleeping problems ");
        radFatigueYes = new JRadioButton("Yes");

        lblAppetite = new JLabel("Do you have any appetite or weight changes ");
        radAppetiteYes = new JRadioButton("Yes");

        lblInterest = new JLabel("Lost of interest ");
        radInterestYes = new JRadioButton("Yes");


        lblAnger = new JLabel("Do you have anger or irritability " );
        radAngerYes = new JRadioButton("Yes");


        lblNervous = new JLabel("Do you get restless or nervous " );
        radNervousYes = new JRadioButton("Yes");

        lblDanger = new JLabel("Do you randomly feel in danger and panic " );
        radDangerYes = new JRadioButton("Yes");

        lblHeartRate = new JLabel("Rapid Heart rate " );
        radHeartRateYes = new JRadioButton("Yes");

        lblHeavySweating = new JLabel("Increased or heavy sweating " );
        radHeavySweatingYes = new JRadioButton("Yes");


        btnSubmit = new JButton("Submit");

        ft1 = new Font("Arial", Font.BOLD, 32);
        ft2 = new Font("Arial", Font.PLAIN, 20);
        ft3 = new Font("Arial", Font.PLAIN, 24);

    }
    public void setGUI() {
        panelNorth.setLayout(new FlowLayout());
        panelCenter.setLayout(new GridLayout(8, 1));
        panelRB1.setLayout(new GridLayout(1, 3));
        panelRB2.setLayout(new GridLayout(8, 2));
        panelSouth.setLayout(new GridLayout(1, 3));

        panelNorth.add(lblHeading);
        lblHeading.setFont(ft1);
        lblHeading.setForeground(Color.white);
        panelNorth.setBackground(Color.blue);
        panelCenter.setBackground(Color.blue);


        lblFatigue.setFont(ft2);
        lblFatigue.setForeground(Color.white);
        lblFatigue.setHorizontalAlignment(JLabel.LEFT);
        radFatigueYes.setFont(ft2);
        radFatigueYes.setHorizontalAlignment(JRadioButton.RIGHT);
        radFatigueYes.setBackground(Color.blue);

        panelCenter.add(lblFatigue);
        panelRB1.add(radFatigueYes);
        panelCenter.add(panelRB1);

        lblAppetite.setFont(ft2);
        lblAppetite.setForeground(Color.white);
        lblAppetite.setHorizontalAlignment(JLabel.LEFT);
        radAppetiteYes.setFont(ft2);
        radAppetiteYes.setHorizontalAlignment(JRadioButton.RIGHT);
        radAppetiteYes.setBackground(Color.BLUE);

        panelCenter.add(lblAppetite);
        panelRB1.add(radAppetiteYes);
        panelCenter.add(panelRB1);

        lblInterest.setFont(ft2);
        lblInterest.setForeground(Color.white);
        lblInterest.setHorizontalAlignment(JLabel.LEFT);
        radInterestYes.setFont(ft2);
        radInterestYes.setHorizontalAlignment(JRadioButton.RIGHT);
        radInterestYes.setBackground(Color.blue);


        panelCenter.add(lblInterest);
        panelRB1.add(radInterestYes);
        panelCenter.add(panelRB1);

        lblAnger.setFont(ft2);
        lblAnger.setForeground(Color.white);
        lblAnger.setHorizontalAlignment(JLabel.LEFT);
        radAngerYes.setFont(ft2);
        radAngerYes.setHorizontalAlignment(JRadioButton.RIGHT);
        radAngerYes.setBackground(Color.blue);

        panelCenter.add(lblAnger);
        panelRB1.add(radAngerYes);
        panelCenter.add(panelRB1);

        lblNervous.setFont(ft2);
        lblNervous.setForeground(Color.white);
        lblNervous.setHorizontalAlignment(JLabel.LEFT);
        radNervousYes.setFont(ft2);
        radNervousYes.setHorizontalAlignment(JRadioButton.RIGHT);
        radNervousYes.setBackground(Color.blue);

        panelCenter.add(lblNervous);
        panelRB1.add(radNervousYes);
        panelCenter.add(panelRB1);

        lblDanger.setFont(ft2);
        lblDanger.setForeground(Color.white);
        lblDanger.setHorizontalAlignment(JLabel.LEFT);
        radDangerYes.setFont(ft2);
        radDangerYes.setHorizontalAlignment(JRadioButton.RIGHT);
        radDangerYes.setBackground(Color.blue);

        panelCenter.add(lblHeartRate);
        panelRB1.add(radHeartRateYes);
        panelCenter.add(panelRB1);

        lblHeartRate.setFont(ft2);
        lblHeartRate.setForeground(Color.white);
        lblHeartRate.setHorizontalAlignment(JLabel.LEFT);
        radHeartRateYes.setFont(ft2);
        radHeartRateYes.setHorizontalAlignment(JRadioButton.RIGHT);
        radHeartRateYes.setBackground(Color.blue);

        panelCenter.add(lblHeartRate);
        panelRB1.add(radHeartRateYes);
        panelCenter.add(panelRB1);

        lblHeavySweating.setFont(ft2);
        lblHeavySweating.setForeground(Color.white);
        lblHeavySweating.setHorizontalAlignment(JLabel.LEFT);
        radHeavySweatingYes.setFont(ft2);
        radHeavySweatingYes.setHorizontalAlignment(JRadioButton.RIGHT);
        radHeavySweatingYes.setBackground(Color.blue);

        panelCenter.add(lblHeavySweating);
        panelRB1.add(radHeavySweatingYes);
        panelCenter.add(panelRB1);

        btnSubmit.setFont(ft3);
        panelSouth.add(btnSubmit);

        this.add(panelNorth, BorderLayout.NORTH);
        this.add(panelCenter, BorderLayout.CENTER);
        this.add(panelSouth, BorderLayout.SOUTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        btnSubmit.addActionListener(this);

        this.setSize(600, 600);
        this.pack();
        this.setVisible(true);
    }
    private boolean isInputValid() {
        return true;
    }
    private void resetForm() {

        radFatigueYes.setSelected(true);

    }
    public void actionPerformed(ActionEvent e) {

    }

    public static void main(String[] args) {
        new SymptomsChecker().setGUI();

    }

}
