package za.ac.cput.mentalhealthapp.counselling.GUIs;

import chrriis.dj.nativeswing.swtimpl.NativeInterface;
import chrriis.dj.nativeswing.swtimpl.components.JWebBrowser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

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
    private JPanel videoPanel;

    public SupportGroupsGUI() {
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

        private void open(URI uri) {
            if (Desktop.isDesktopSupported()) {
                try {
                    Desktop.getDesktop().browse(uri);
                } catch (IOException e) { /* TODO: error handling */ }
            } else { /* TODO: error handling */ }
        }


        private void createUIComponents() throws URISyntaxException {
            // TODO: place custom component creation code here
            final URI uri = new URI("https://youtu.be/ebQVU5o_0RY");
            class OpenUrlAction implements ActionListener {
                @Override
                public void actionPerformed(ActionEvent e) {
                    open(uri);
                }
            }
            JButton button = new JButton();
            videoPanel = new JPanel();
            button.setText("<HTML>Click the <FONT color= \" #000099 \" ><U>link</U></FONT>");
            button.setHorizontalAlignment(SwingConstants.LEFT);
            button.setBorderPainted(false);
            button.setOpaque(false);
            button.setBackground(Color.WHITE);
            button.setToolTipText(uri.toString());
            button.addActionListener(new OpenUrlAction());
            videoPanel.add(button);

        }
}

