package edu.gonzaga;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import javax.swing.*;

public class BackgroundChangeExample extends JFrame implements ActionListener {

    private JLabel label;
    private JButton button;
    private JPanel contentPane;
    private String currentBackgroundImage;

    public BackgroundChangeExample() {
        super("Background Change Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set initial background image
        currentBackgroundImage = "GameArt/lightWood.jpg";
        setContentPane(createBackgroundPanel());

        // Add label and button to content pane
        label = new JLabel("Click the button to change the background.");
        button = new JButton("Change Background");
        button.addActionListener(this);

        contentPane = (JPanel) getContentPane();
        contentPane.add(label);
        contentPane.add(button);

        // Set size and make frame visible
        setSize(400, 300);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private JPanel createBackgroundPanel() {
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Image backgroundImage = new ImageIcon(currentBackgroundImage).getImage();
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), null);
            }
        };
        panel.setLayout(new FlowLayout());
        return panel;
    }

    private void updateBackgroundImage(String newImageFileName) {
        currentBackgroundImage = newImageFileName;
        contentPane.remove(0);
        contentPane.add(createBackgroundPanel(), 0);
        validate();
        repaint();
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            JFileChooser fileChooser = new JFileChooser();
            int result = fileChooser.showOpenDialog(this);
            if (result == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                updateBackgroundImage(selectedFile.getAbsolutePath());
            }
        }
    }

    public static void main(String[] args) {
        new BackgroundChangeExample();
    }

}
