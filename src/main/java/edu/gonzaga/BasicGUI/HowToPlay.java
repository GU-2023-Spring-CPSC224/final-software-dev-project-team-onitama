package edu.gonzaga.BasicGUI;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class HowToPlay extends JFrame implements ActionListener
{
    public static void main(String[] args)
    {
        new HowToPlay();
    }

    JLabel howToPlayLabel;
    JButton backButton;
    JTextArea instructionsTextArea;


    HowToPlay()
    {
        howToPlayLabel = new JLabel();

        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setVisible(true);//this makes the frame visible
        //this.setSize(600,600);//sets x & y dimensions
        this.setTitle("Onitama");//setting title
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//what happens when we close the window
        this.setResizable(true);//we can change whether frame may be resized
        this.getContentPane().setBackground(Color.WHITE);//changing color of frame
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        ImageIcon image = new ImageIcon("OnitamaLogo.png"); //creates an image icon
        this.setIconImage(image.getImage()); //changes icon of frame
        this.setLayout(null);
        ImageIcon imageIcon = new ImageIcon("boardBackground.png");
        JLabel backgroundLabel = new JLabel(imageIcon);
        this.setContentPane(backgroundLabel);

        //BufferedImage myImage = ImageIO.read();
        JFrame myJFrame = new JFrame("boardBackground.png");
        //myJFrame.setContentPane(new ImagePanel(myImage));


        howToPlayLabel.setBounds(690, 100, 400, 100);
        howToPlayLabel.setFont(new Font("MV Boli", Font.BOLD, 20));
        howToPlayLabel.setText("How to play");


        backButton = new JButton();
        backButton.setText("Back");
        backButton.setFont(new Font("MV Boli", Font.BOLD, 15));
        backButton.setBounds(1410, 725, 100, 50);
        backButton.addActionListener(this);
        backButton.setFocusable(false);
        backButton.setForeground(Color.BLACK);

        instructionsTextArea = new JTextArea();
        instructionsTextArea.setText("mystringtest");
        instructionsTextArea.setFont(new Font("MV Boli", Font.BOLD, 15));
        instructionsTextArea.setEditable(false);
        instructionsTextArea.setPreferredSize(new Dimension(600, 400));
        instructionsTextArea.setBounds(50, 200, 1430, 800);
        instructionsTextArea.setLineWrap(true);
        instructionsTextArea.setWrapStyleWord(true);
        String instructionString = "You can never make a move that would cause a pawn to move off the board or move onto the same square as one of your own pawns.";
        instructionString += "If your pawn moves onto a square that is occupied by one of your opponent's pawns, the opponent's pawn is captured and removed from the game. Put it back in the box.";
        instructionString += "You must actually land on the piece to capture it - moving over or through a square occupied by an opponent's piece does not capture it.";
        instructionsTextArea.setText(instructionString);
        this.add(howToPlayLabel);
        this.add(backButton);
        this.add(instructionsTextArea);

        

    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == backButton)
        {
            dispose();
        }
    }
}
