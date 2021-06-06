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
    private JButton searchB = new JButton();
    private JLabel lblHeading;


    private JLabel lblFatigue;
    private JRadioButton radFatigueYes;
    private JRadioButton radFatigueNo;
    private ButtonGroup fatigueGroup;

    private JLabel lblAppetite;
    private JRadioButton radAppetiteYes;
    private JRadioButton radAppetiteNo;
    private ButtonGroup appetiteGroup;

    private JLabel lblInterest;
    private JRadioButton radInterestYes;
    private JRadioButton radInterestNo;
    private ButtonGroup interestGroup;

    private JLabel lblAnger;
    private JRadioButton radAngerYes;
    private JRadioButton radAngerNo;
    private ButtonGroup angerGroup;

    private JLabel lblNervous;
    private JRadioButton radNervousYes;
    private JRadioButton radNervousNo;
    private ButtonGroup nervousGroup;

    private JLabel lblDanger;
    private JRadioButton radDangerYes;
    private JRadioButton radDangerNo;
    private ButtonGroup dangerGroup;

    private JButton btnSubmit;
    private Font ft1, ft2, ft3;

    public SymptomsChecker() {
        panelNorth = new JPanel();
        panelCenter = new JPanel();
        panelRB1 = new JPanel();
        panelRB2 = new JPanel();
        panelSouth = new JPanel();

        lblHeading = new JLabel(" Symptoms Checker ");

        lblFatigue = new JLabel("Increased fatigue and sleeping problem: ");
        radFatigueYes = new JRadioButton("Yes");
        radFatigueNo = new JRadioButton("No");
        fatigueGroup = new ButtonGroup();

        lblAppetite = new JLabel("Do you have any appetite or weight changes: ");
        radAppetiteYes = new JRadioButton("Yes");
        radAppetiteNo = new JRadioButton("No");
        appetiteGroup = new ButtonGroup();

        lblInterest = new JLabel(" Lost of interest ");
        radInterestYes = new JRadioButton("Yes");
        radInterestNo = new JRadioButton("No");
        interestGroup = new ButtonGroup();

        lblAnger = new JLabel(" do you have anger or irritability " );
        radAngerYes = new JRadioButton("Yes");
        radAngerNo = new JRadioButton("No");
        angerGroup = new ButtonGroup();

        lblNervous = new JLabel(" do do you get restless or nervous " );
        radNervousYes = new JRadioButton("Yes");
        radNervousNo = new JRadioButton("No");
        nervousGroup = new ButtonGroup();

        lblDanger = new JLabel(" do you randomly feel in danger and panic " );
        radDangerYes = new JRadioButton("Yes");
        radDangerNo = new JRadioButton("No");
        dangerGroup = new ButtonGroup();

        btnSubmit = new JButton("Submit");

        ft1 = new Font("Arial", Font.BOLD, 32);
        ft2 = new Font("Arial", Font.PLAIN, 22);
        ft3 = new Font("Arial", Font.PLAIN, 24);

    }
    public void setGUI() {
        panelNorth.setLayout(new FlowLayout());
        panelCenter.setLayout(new GridLayout(5, 2));
        panelRB1.setLayout(new GridLayout(1, 2));
        panelRB2.setLayout(new GridLayout(1, 2));
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
        radFatigueNo.setFont(ft2);
        radFatigueNo.setHorizontalAlignment(JRadioButton.RIGHT);
        radFatigueNo.setBackground(Color.blue);
        radFatigueNo.setSelected(true);

        fatigueGroup.add(radFatigueYes);
        fatigueGroup.add(radFatigueNo);

        panelCenter.add(lblFatigue);
        panelRB1.add(radFatigueYes);
        panelRB1.add(radFatigueNo);
        panelCenter.add(panelRB1);
        lblAppetite.setFont(ft2);
        lblAppetite.setForeground(Color.white);
        lblAppetite.setHorizontalAlignment(JLabel.LEFT);
        radAppetiteYes.setFont(ft2);
        radAppetiteYes.setHorizontalAlignment(JRadioButton.RIGHT);
        radAppetiteYes.setBackground(Color.BLUE);
        radAppetiteNo.setFont(ft2);
        radAppetiteNo.setHorizontalAlignment(JRadioButton.RIGHT);
        radAppetiteNo.setBackground(Color.blue);
        radAppetiteNo.setSelected(true);

        appetiteGroup.add(radFatigueYes);
        appetiteGroup.add(radFatigueNo);

        panelCenter.add(lblAppetite);
        panelRB1.add(radAppetiteYes);
        panelRB1.add(radAppetiteNo);
        panelCenter.add(panelRB1);

        lblInterest.setFont(ft2);
        lblInterest.setForeground(Color.white);
        lblInterest.setHorizontalAlignment(JLabel.LEFT);
        radInterestYes.setFont(ft2);
        radInterestYes.setHorizontalAlignment(JRadioButton.RIGHT);
        radInterestYes.setBackground(Color.blue);
        radInterestNo.setFont(ft2);
        radInterestNo.setHorizontalAlignment(JRadioButton.RIGHT);
        radInterestNo.setBackground(Color.blue);
        radInterestNo.setSelected(true);

        interestGroup.add(radFatigueYes);
        interestGroup.add(radFatigueNo);

        panelCenter.add(lblInterest);
        panelRB1.add(radInterestYes);
        panelRB1.add(radInterestNo);
        panelCenter.add(panelRB1);

        lblAnger.setFont(ft2);
        lblAnger.setForeground(Color.white);
        lblAnger.setHorizontalAlignment(JLabel.LEFT);
        radAngerYes.setFont(ft2);
        radAngerYes.setHorizontalAlignment(JRadioButton.RIGHT);
        radAngerYes.setBackground(Color.blue);
        radAngerNo.setFont(ft2);
        radAngerNo.setHorizontalAlignment(JRadioButton.RIGHT);
        radAngerNo.setBackground(Color.blue);
        radAngerNo.setSelected(true);

        angerGroup.add(radFatigueYes);
        angerGroup.add(radFatigueNo);

        panelCenter.add(lblAnger);
        panelRB1.add(radAngerYes);
        panelRB1.add(radAngerNo);
        panelCenter.add(panelRB1);

        lblNervous.setFont(ft2);
        lblNervous.setForeground(Color.white);
        lblNervous.setHorizontalAlignment(JLabel.LEFT);
        radNervousYes.setFont(ft2);
        radNervousYes.setHorizontalAlignment(JRadioButton.RIGHT);
        radNervousYes.setBackground(Color.blue);
        radNervousNo.setFont(ft2);
        radNervousNo.setHorizontalAlignment(JRadioButton.RIGHT);
        radNervousNo.setBackground(Color.blue);
        radNervousNo.setSelected(true);

        nervousGroup.add(radFatigueYes);
        nervousGroup.add(radFatigueNo);

        panelCenter.add(lblNervous);
        panelRB1.add(radNervousYes);
        panelRB1.add(radNervousNo);
        panelCenter.add(panelRB1);

        lblDanger.setFont(ft2);
        lblDanger.setForeground(Color.white);
        lblDanger.setHorizontalAlignment(JLabel.LEFT);
        radDangerYes.setFont(ft2);
        radDangerYes.setHorizontalAlignment(JRadioButton.RIGHT);
        radDangerYes.setBackground(Color.blue);
        radDangerNo.setFont(ft2);
        radDangerNo.setHorizontalAlignment(JRadioButton.RIGHT);
        radDangerNo.setBackground(Color.blue);
        radDangerNo.setSelected(true);

        dangerGroup.add(radDangerYes);
        dangerGroup.add(radDangerNo);

        panelCenter.add(lblDanger);
        panelRB1.add(radDangerYes);
        panelRB1.add(radDangerNo);
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
