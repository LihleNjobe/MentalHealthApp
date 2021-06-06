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
    private JButton btnSubmit;
    private Font ft1, ft2, ft3;
    private JLabel lblFatigue;
    private JRadioButton radFatigue;
    private JLabel lblAppetite;
    private JRadioButton radAppetite;
    private JLabel lblInterest;
    private JRadioButton radInterest;
    private JLabel lblAnger;
    private JRadioButton radAnger;
    private JLabel lblNervous;
    private JRadioButton radNervous;
    private JLabel lblPanic;
    private JRadioButton radPanic;
    private JLabel lblHeartRate;
    private JRadioButton radHeartRate;
    private JLabel lblHeavySweating;
    private JRadioButton radHeavySweating;

    public SymptomsChecker() {
        panelNorth = new JPanel();
        panelCenter = new JPanel();
        panelRB1 = new JPanel();
        panelRB2 = new JPanel();
        panelSouth = new JPanel();
        lblHeading = new JLabel("Symptoms Checker");

        lblFatigue = new JLabel(" Do you have increased fatigue and sleeping patterns ");
        radFatigue = new JRadioButton();
        lblAppetite = new JLabel(" Appetite lose or weight changes ");
        radAppetite = new JRadioButton();
        lblInterest = new JLabel(" Loss of interest ");
        radInterest = new JRadioButton();
        lblAnger = new JLabel(" Do you have anger or irritability issues ");
        radAnger = new JRadioButton();
        lblNervous = new JLabel(" Do you randomly get nervous or restless ");
        radNervous = new JRadioButton();
        lblPanic = new JLabel(" Do you get a feeling of danger and panic ");
        radPanic = new JRadioButton();
        lblHeartRate = new JLabel(" Rapid or increased heart rate ");
        radHeartRate = new JRadioButton();
        lblHeavySweating = new JLabel(" Increased or heavy sweating ");
        radHeavySweating = new JRadioButton();

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

        lblFatigue.setFont(ft2);
        lblFatigue.setHorizontalAlignment(JLabel.RIGHT);
        radFatigue.setFont(ft2);
        radFatigue.setHorizontalAlignment(JRadioButton.CENTER);
        radFatigue.setBackground(new Color(36, 145, 255));

        lblAppetite.setFont(ft2);
        lblAppetite.setHorizontalAlignment(JLabel.RIGHT);
        radAppetite.setFont(ft2);
        radAppetite.setHorizontalAlignment(JRadioButton.CENTER);
        radAppetite.setBackground(new Color(36, 145, 255));

        lblInterest.setFont(ft2);
        lblInterest.setHorizontalAlignment(JLabel.RIGHT);
        radInterest.setFont(ft2);
        radInterest.setHorizontalAlignment(JRadioButton.CENTER);
        radInterest.setBackground(new Color(36, 145, 255));

        lblAnger.setFont(ft2);
        lblAnger.setHorizontalAlignment(JLabel.RIGHT);
        radAnger.setFont(ft2);
        radAnger.setHorizontalAlignment(JRadioButton.CENTER);
        radAnger.setBackground(new Color(36, 145, 255));

        lblNervous.setFont(ft2);
        lblNervous.setHorizontalAlignment(JLabel.RIGHT);
        radNervous.setFont(ft2);
        radNervous.setHorizontalAlignment(JRadioButton.CENTER);
        radNervous.setBackground(new Color(36, 145, 255));

        lblPanic.setFont(ft2);
        lblPanic.setHorizontalAlignment(JLabel.RIGHT);
        radPanic.setFont(ft2);
        radPanic.setHorizontalAlignment(JRadioButton.CENTER);
        radPanic.setBackground(new Color(36, 145, 255));

        lblHeartRate.setFont(ft2);
        lblHeartRate.setHorizontalAlignment(JLabel.RIGHT);
        radHeartRate.setFont(ft2);
        radHeartRate.setHorizontalAlignment(JRadioButton.CENTER);
        radHeartRate.setBackground(new Color(36, 145, 255));

        lblHeavySweating.setFont(ft2);
        lblHeavySweating.setHorizontalAlignment(JLabel.RIGHT);
        radHeavySweating.setFont(ft2);
        radHeavySweating.setHorizontalAlignment(JRadioButton.CENTER);
        radHeavySweating.setBackground(new Color(36, 145, 255));


    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
