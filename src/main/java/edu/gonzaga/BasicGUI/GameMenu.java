package edu.gonzaga.BasicGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameMenu extends JFrame implements ActionListener
{
    JButton newGameButton;
    JButton instructionsButton;
    JButton optionsButton;
    JButton quitButton;
    GameFrame frame;
    JPanel startMenuPanel;
    JLabel gameTitleLabel;

    Options s;

    public static void main(String[] args)
    {
        new GameMenu();
    }

    GameMenu()
    {
        frame = new GameFrame();
        gameTitleLabel = new JLabel("Onitama: A two player strategy game");
        startMenuPanel = new JPanel();
        newGameButton = new JButton();
        instructionsButton = new JButton();
        optionsButton = new JButton();
        quitButton = new JButton();
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);


        /*ImageIcon gameTitleImage = new ImageIcon("OnitamaLettering.png");
        gameTitleLabel.setIcon(gameTitleImage);*/
        gameTitleLabel.setBounds(315, 100, 700, 300);
        gameTitleLabel.setFont(new Font("MV Boli", Font.BOLD, 20));



        newGameButton.setBounds(500, 350, 500, 200);
        newGameButton.setText("New Game");
        newGameButton.setFont(new Font("MV Boli", Font.BOLD, 15));
        newGameButton.setFocusable(false);
        newGameButton.addActionListener(this);
        
        


        instructionsButton.setBounds(500, 500, 500, 200);
        instructionsButton.setText("How to play");
        instructionsButton.setFont(new Font("MV Boli", Font.BOLD, 15));
        instructionsButton.setFocusable(false);
        instructionsButton.addActionListener(this);
        instructionsButton.setForeground(Color.BLACK);


        // optionsButton.setBounds(600, 390, 350, 60);
        // optionsButton.setText("Options");
        // optionsButton.setFont(new Font("MV Boli", Font.BOLD, 15));
        // optionsButton.setFocusable(false);
        // optionsButton.addActionListener(this);
        // optionsButton.setForeground(Color.BLACK);


        quitButton.setBounds(500, 650, 500, 200);
        quitButton.setText("Quit");
        quitButton.setFont(new Font("MV Boli", Font.BOLD, 15));
        quitButton.setFocusable(false);
        quitButton.addActionListener(this);
        quitButton.setForeground(Color.BLACK);
        



        frame.add(gameTitleLabel);
        frame.add(newGameButton);
        //frame.add(optionsButton);
        frame.add(instructionsButton);
        frame.add(quitButton);
        frame.setVisible(true);

        newGameButton.setOpaque(false);
        newGameButton.setContentAreaFilled(false);
        newGameButton.setBorderPainted(false);
        newGameButton.setIcon(new ImageIcon("GameArt/NewGameZ.png"));
        instructionsButton.setOpaque(false);
        instructionsButton.setContentAreaFilled(false);
        instructionsButton.setBorderPainted(false);
        instructionsButton.setIcon(new ImageIcon("GameArt/RulesZ.png"));
        quitButton.setOpaque(false);
        quitButton.setContentAreaFilled(false);
        quitButton.setBorderPainted(false);
        quitButton.setIcon(new ImageIcon("GameArt/QuitZ.png"));
        gameTitleLabel.setIcon(new ImageIcon("GameArt/OnitamaZ.png"));
        gameTitleLabel.setVisible(true);

    }


    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == newGameButton)
        {
            CharacterSelect c = new CharacterSelect();
        }
        if (e.getSource() == instructionsButton)
        {
            HowToPlay h = new HowToPlay();
        }
        if (e.getSource() == optionsButton)
        {
            s = new Options();
        }
        if (e.getSource() == quitButton)
        {
            System.exit(0);
        }
    }
}