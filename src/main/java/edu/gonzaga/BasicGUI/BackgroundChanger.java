package edu.gonzaga.BasicGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BackgroundChanger implements ActionListener {

    private JFrame frame;
    private JPanel contentPane;
    private JButton changeButton;
    private JLabel label;
    private ImageIcon backgroundImage;

    public BackgroundChanger() {
        // Create the frame and set its properties
        frame = new JFrame("heres my frame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);


        // Create the content pane and set its layout
        contentPane = new JPanel(new BorderLayout());

        // Create the button and add an action listener to it
        changeButton = new JButton("Change Background");
        changeButton.addActionListener(this);

        // Create the label and set its properties
        label = new JLabel();
        label.setVerticalAlignment(JLabel.CENTER);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setText("This is the label text");

        // Load the initial background image
        backgroundImage = new ImageIcon("GameArt/lightWood.jpg");
        JLabel backgroundLabel = new JLabel(backgroundImage);
        contentPane.add(backgroundLabel, BorderLayout.CENTER);

        // Add the components to the content pane
        contentPane.add(changeButton, BorderLayout.NORTH);
        contentPane.add(label, BorderLayout.SOUTH);

        JLabel myLabel = new JLabel("testing the label");
        frame.add(myLabel);

        // Set the content pane of the frame
        frame.setContentPane(contentPane);

        // Show the frame
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Load the new background image
        backgroundImage = new ImageIcon("GameArt/colorfulBricks.png");
        JLabel backgroundLabel = new JLabel(backgroundImage);

        // Get the components from the content pane
        Component[] components = contentPane.getComponents();

        // Remove the old background label from the content pane
        for (Component component : components) {
            if (component instanceof JLabel && ((JLabel) component).getIcon() != null) {
                contentPane.remove(component);
                break;
            }
        }

        // Add the new background label to the content pane
        contentPane.add(backgroundLabel, BorderLayout.CENTER);

        // Repaint the content pane
        contentPane.revalidate();
        contentPane.repaint();
    }

    public static void main(String[] args) {
        new BackgroundChanger();
    }
}
