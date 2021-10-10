/*
*This is a symptoms checker file, where the user will click their current symptoms on the radio button beside
each symptom
* @Author: Lihle Njobe- 218193882
* Due date: 07 June 2021
 */
package za.ac.cput.mentalhealthapp.symptoms;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class Symptoms extends JFrame implements ActionListener {

    private JPanel panelNorth;
    private JPanel panelCenter, panelRB1, panelRB2;
    private JPanel panelSouth;
    private JLabel lblHeading;
    private JPanel interestPanel;
    private JPanel appetitePanel;
    private JPanel fatiguePanel;
    private JPanel angerPanel;
    private JPanel panicPanel;
    private JPanel heartRatePanel;
    private JPanel sweatingPanel;
    private JPanel nervesPanel;
    private JLabel space;

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

    private JButton btnSubmit, btnClear, btnExit;
    private Font ft1, ft2, ft3;

    public Symptoms() {
        panelNorth = new JPanel();
        panelCenter = new JPanel();
        panelRB1 = new JPanel();
        panelRB2 = new JPanel();
        panelSouth = new JPanel();

        fatiguePanel = new JPanel();
        appetitePanel = new JPanel();
        interestPanel = new JPanel();
        angerPanel = new JPanel();
        nervesPanel = new JPanel();
        panicPanel = new JPanel();
        heartRatePanel = new JPanel();
        sweatingPanel = new JPanel();
        space = new JLabel("");

        lblHeading = new JLabel(" Symptoms Checker ", JLabel.CENTER);

        lblFatigue = new JLabel("Increased fatigue and sleeping problems ");
        radFatigueYes = new JRadioButton();

        lblAppetite = new JLabel("Do you have any appetite or weight changes ");
        radAppetiteYes = new JRadioButton();

        lblInterest = new JLabel("Lost of interest ");
        radInterestYes = new JRadioButton();

        lblAnger = new JLabel("Do you have anger or irritability ");
        radAngerYes = new JRadioButton();

        lblNervous = new JLabel("Do you get restless or nervous ");
        radNervousYes = new JRadioButton();

        lblDanger = new JLabel("Do you randomly feel in danger and panic ");
        radDangerYes = new JRadioButton();

        lblHeartRate = new JLabel("Rapid Heart rate ");
        radHeartRateYes = new JRadioButton();

        lblHeavySweating = new JLabel("Increased or heavy sweating ");
        radHeavySweatingYes = new JRadioButton();

        btnSubmit = new JButton("Submit");
        btnClear = new JButton("Clear");
        btnExit = new JButton("Exit");

        ft1 = new Font("Arial", Font.BOLD, 20);
        ft2 = new Font("Arial", Font.PLAIN, 16);
        ft3 = new Font("Arial", Font.PLAIN, 16);

    }

    public void setGUI() {
        panelNorth.setLayout(new FlowLayout());
        panelCenter.setLayout(new GridLayout(10, 3));

        panelRB1.setLayout(new GridLayout(1, 2));
        panelRB2.setLayout(new GridLayout(8, 2));
        panelSouth.setLayout(new GridLayout(1, 3));

        radInterestYes.setHorizontalAlignment(JRadioButton.LEFT);

        fatiguePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        appetitePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        interestPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        angerPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        nervesPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        panicPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        heartRatePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        sweatingPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

        panelNorth.add(lblHeading);
        lblHeading.setFont(ft1);
        lblHeading.setForeground(Color.white);
        panelNorth.setBackground(Color.blue);
        panelCenter.setBackground(Color.blue);

//        panelCenter.add(space);

        lblFatigue.setFont(ft2);
        lblFatigue.setForeground(Color.white);
        lblFatigue.setHorizontalAlignment(JLabel.LEFT);
        radFatigueYes.setFont(ft2);
        radFatigueYes.setHorizontalAlignment(JRadioButton.RIGHT);
        radFatigueYes.setBackground(Color.blue);

        fatiguePanel.add(radFatigueYes);
        fatiguePanel.add(lblFatigue);
        fatiguePanel.setBackground(Color.blue);
        panelCenter.add(fatiguePanel);

        lblAppetite.setFont(ft2);
        lblAppetite.setForeground(Color.white);
        radAppetiteYes.setFont(ft2);
        radAppetiteYes.setBackground(Color.BLUE);

        appetitePanel.add(radAppetiteYes);
        appetitePanel.add(lblAppetite);
        appetitePanel.setBackground(Color.blue);
        panelCenter.add(appetitePanel);

        lblInterest.setFont(ft2);
        lblInterest.setForeground(Color.white);
        lblInterest.setHorizontalAlignment(JLabel.LEFT);
        radInterestYes.setFont(ft2);
        radInterestYes.setBackground(Color.blue);

        interestPanel.add(radInterestYes);
        interestPanel.add(lblInterest);
        interestPanel.setBackground(Color.blue);
        panelCenter.add(interestPanel);

        lblAnger.setFont(ft2);
        lblAnger.setForeground(Color.white);
        lblAnger.setHorizontalAlignment(JLabel.LEFT);
        radAngerYes.setFont(ft2);
        radAngerYes.setBackground(Color.blue);

        angerPanel.add(radAngerYes);
        angerPanel.add(lblAnger);
        angerPanel.setBackground(Color.blue);
        panelCenter.add(angerPanel);

        lblNervous.setFont(ft2);
        lblNervous.setForeground(Color.white);
        lblNervous.setHorizontalAlignment(JLabel.LEFT);
        radNervousYes.setFont(ft2);
        radNervousYes.setBackground(Color.blue);

        nervesPanel.add(radNervousYes);
        nervesPanel.add(lblNervous);
        nervesPanel.setBackground(Color.blue);
        panelCenter.add(nervesPanel);

        lblDanger.setFont(ft2);
        lblDanger.setForeground(Color.white);
        lblDanger.setHorizontalAlignment(JLabel.LEFT);
        radDangerYes.setFont(ft2);
        radDangerYes.setBackground(Color.blue);

        panicPanel.add(radDangerYes);
        panicPanel.add(lblDanger);
        panicPanel.setBackground(Color.blue);
        panelCenter.add(panicPanel);

        lblHeartRate.setFont(ft2);
        lblHeartRate.setForeground(Color.white);
        lblHeartRate.setHorizontalAlignment(JLabel.LEFT);
        radHeartRateYes.setFont(ft2);
        radHeartRateYes.setBackground(Color.blue);

        heartRatePanel.add(radHeartRateYes);
        heartRatePanel.add(lblHeartRate);
        heartRatePanel.setBackground(Color.blue);
        panelCenter.add(heartRatePanel);

        lblHeavySweating.setFont(ft2);
        lblHeavySweating.setForeground(Color.white);
        lblHeavySweating.setHorizontalAlignment(JLabel.LEFT);
        radHeavySweatingYes.setFont(ft2);
        radHeavySweatingYes.setBackground(Color.blue);

        sweatingPanel.add(radHeavySweatingYes);
        sweatingPanel.add(lblHeavySweating);
        sweatingPanel.setBackground(Color.blue);
        panelCenter.add(sweatingPanel);

        btnSubmit.setFont(ft3);
        btnClear.setFont(ft3);
        btnExit.setFont(ft3);

        panelSouth.add(btnSubmit);
        panelSouth.add(btnClear);
        panelSouth.add(btnExit);

        this.add(panelNorth, BorderLayout.NORTH);
//        this.add(panelRB1, BorderLayout.CENTER);
        this.add(panelCenter, BorderLayout.CENTER);
        this.add(panelSouth, BorderLayout.SOUTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        btnSubmit.addActionListener(this);
        btnClear.addActionListener(this);
        btnExit.addActionListener(this);

        this.setPreferredSize(new Dimension(360, 600));
        this.pack();
        this.setVisible(true);
    }

    private void clearForm() {
        radFatigueYes.setSelected(true);
        radAppetiteYes.setSelected(true);
        radInterestYes.setSelected(true);
        radAngerYes.setSelected(true);
        radNervousYes.setSelected(true);
        radDangerYes.setSelected(true);
        radHeartRateYes.setSelected(true);
        radHeavySweatingYes.setSelected(true);
    }

    private boolean isInputValid() {
        return true;
    }
    public void actionPerformed(ActionEvent e) {
    if (e.getActionCommand().equals("Submit")) {
        if (isInputValid()) {
            SymptomsChecker checker = new SymptomsChecker(radFatigueYes.isSelected(),
            radAppetiteYes.isSelected(),
            radInterestYes.isSelected(),
            radAngerYes.isSelected(),
            radNervousYes.isSelected(),
            radDangerYes.isSelected(),
             radHeartRateYes.isSelected(),
             radHeavySweatingYes.isSelected();
            checker.submit();
           clearForm();
            }
    }
         else if (e.getActionCommand().equals("Clear")) {
        clearForm();
    }
        else if (e.getActionCommand().equals("Exit")) {
        System.exit(0);
    }
}

        public static void main (String[]args){
            new Symptoms().setGUI();
            new JComboBox();
        }
    }
