package za.ac.cput.mentalhealthapp.symptoms;
import java.io.*;
import javax.swing.JOptionPane;

public class SymptomsChecker {

    private String fatigue;
    private String appetite;
    private String interest;
    private String anger;
    private String danger;
    private String heartRate;
    private String heavySweating;

    public SymptomsChecker(String fatigue, String appetite, String interest, String anger, String danger, String heartRate, String heavySweating) {
        this.fatigue = fatigue;
        this.appetite = appetite;
        this.interest = interest;
        this.anger = anger;
        this.danger = danger;
        this.heartRate = heartRate;
        this.heavySweating = heavySweating;

    }

    public void submit() {
        PrintWriter out = null;
        String message = "The information is submitted";
        try {
            out = new PrintWriter(new FileWriter("symptoms.txt", true));
            out.println(fatigue);
            out.println(appetite);
            out.println(interest);
            out.println(anger);
            out.println(danger);
            out.println(heartRate);
            out.println(heavySweating);
        } catch (IOException e) {
            // Catch any IO exceptions
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return;
        } finally {
            // Close the file print writer
            out.close();
        }
        JOptionPane.showMessageDialog(null, message, "Status", JOptionPane.INFORMATION_MESSAGE);
    }
}