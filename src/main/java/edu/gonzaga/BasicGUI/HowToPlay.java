package edu.gonzaga.BasicGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HowToPlay implements ActionListener
{

    JLabel howToPlayLabel;
    JButton backButton;
    JTextArea instructionsTextArea;
    JFrame mainWindowFrame;


    HowToPlay()
    {
        howToPlayLabel = new JLabel();
        mainWindowFrame = new GameFrame();


        howToPlayLabel.setBounds(690, 100, 400, 100);
        howToPlayLabel.setFont(new Font("MV Boli", Font.BOLD, 40));
        howToPlayLabel.setText("How to play");
        howToPlayLabel.setForeground(Color.WHITE);



        backButton = new JButton();
        backButton.setText("Back");
        backButton.setFont(new Font("MV Boli", Font.BOLD, 15));
        backButton.setBounds(1410, 725, 100, 50);
        backButton.addActionListener(this);
        backButton.setFocusable(false);
        backButton.setForeground(Color.BLACK);

        instructionsTextArea = new JTextArea();
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
        instructionsTextArea.setOpaque(false);




        mainWindowFrame.add(howToPlayLabel);
        mainWindowFrame.add(backButton);
        mainWindowFrame.add(instructionsTextArea);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == backButton)
        {
            mainWindowFrame.dispose();
        }
    }
}
