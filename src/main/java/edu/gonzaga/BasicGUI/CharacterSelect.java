package edu.gonzaga.BasicGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CharacterSelect extends JFrame implements ActionListener
{

    JLabel characterSelectLabel;
    JButton backButton;
    JButton readyButton;

    JButton playerOneCharacterA;
    JButton playerOneCharacterB;
    JButton playerOneCharacterC;
    JButton playerOneCharacterD;

    JButton playerTwoCharacterA;
    JButton playerTwoCharacterB;
    JButton playerTwoCharacterC;
    JButton playerTwoCharacterD;

    boolean playerOneCharacterSelected = false;
    boolean playerTwoCharacterSelected = false;




    public static void main(String[] args)
    {
        new CharacterSelect();
    }

    CharacterSelect()
    {
        characterSelectLabel = new JLabel();

        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setVisible(true);//this makes the frame visible
        //this.setSize(600,600);//sets x & y dimensions
        this.setTitle("Onitama");//setting title
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//what happens when we close the window
        this.setResizable(true);//we can change whether frame may be resized
        this.getContentPane().setBackground(Color.WHITE);//changing color of frame
        this.setLayout(null);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        ImageIcon image = new ImageIcon("OnitamaLogo.png"); //creates an image icon
        this.setIconImage(image.getImage()); //changes icon of frame


        characterSelectLabel.setBounds(640, 100, 400, 100);
        characterSelectLabel.setFont(new Font("MV Boli", Font.BOLD, 30));
        characterSelectLabel.setText("Character Select");

        backButton = new JButton();
        backButton.setText("Back");
        backButton.setFont(new Font("MV Boli", Font.BOLD, 15));
        backButton.setBounds(1410, 725, 100, 50);
        backButton.addActionListener(this);
        backButton.setFocusable(false);
        backButton.setForeground(Color.BLACK);

        readyButton = new JButton();
        readyButton.setText("Ready!");
        readyButton.setFont(new Font("MV Boli", Font.BOLD, 15));
        readyButton.setBounds(690, 350, 150, 75);
        readyButton.addActionListener(this);
        readyButton.setFocusable(false);
        readyButton.setForeground(Color.BLACK);


        JPanel leftCharacterPanel = new JPanel();
        leftCharacterPanel.setBounds(100, 200, 400, 400);
        leftCharacterPanel.setLayout(new GridLayout(2,2));

        playerOneCharacterA = new JButton();
        ImageIcon playerOneCharacterAImage = new ImageIcon("mario.png");
        playerOneCharacterA.setIcon(playerOneCharacterAImage);

        playerOneCharacterB = new JButton();
        ImageIcon playerOneCharacterBImage = new ImageIcon("pacman.png");
        playerOneCharacterB.setIcon(playerOneCharacterBImage);

        playerOneCharacterC = new JButton();
        ImageIcon playerOneCharacterCImage = new ImageIcon("sonic.png");
        playerOneCharacterC.setIcon(playerOneCharacterCImage);

        playerOneCharacterD = new JButton();
        ImageIcon playerOneCharacterDImage = new ImageIcon("pikachu.png");
        playerOneCharacterD.setIcon(playerOneCharacterDImage);

        leftCharacterPanel.add(playerOneCharacterA);
        leftCharacterPanel.add(playerOneCharacterB);
        leftCharacterPanel.add(playerOneCharacterC);
        leftCharacterPanel.add(playerOneCharacterD);

        //leftCharacterPanel.setPreferredSize(new Dimension(300, 400));
        //containerPanel.add(leftCharacterPanel);

        JPanel rightCharacterPanel = new JPanel();
        rightCharacterPanel.setBounds(1030, 200, 400, 400);
        rightCharacterPanel.setLayout(new GridLayout(2,2));

        playerTwoCharacterA = new JButton();
        playerTwoCharacterA.setIcon(playerOneCharacterAImage);

        playerTwoCharacterB = new JButton();
        playerTwoCharacterB.setIcon(playerOneCharacterBImage);

        playerTwoCharacterC = new JButton();
        playerTwoCharacterC.setIcon(playerOneCharacterCImage);

        playerTwoCharacterD = new JButton();
        playerTwoCharacterD.setIcon(playerOneCharacterDImage);

        rightCharacterPanel.add(playerTwoCharacterA);
        rightCharacterPanel.add(playerTwoCharacterB);
        rightCharacterPanel.add(playerTwoCharacterC);
        rightCharacterPanel.add(playerTwoCharacterD);



        //this.getContentPane().add(containerPanel);
        this.add(leftCharacterPanel);
        this.add(rightCharacterPanel);
        this.add(characterSelectLabel);
        this.add(backButton);
        this.add(readyButton);

        if (playerOneCharacterSelected && playerTwoCharacterSelected)
        {
            dispose();
            new NewGame();
        }
    }


    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == backButton)
        {
            dispose();
        }
        if (e.getSource() == playerOneCharacterA)
        {

        }
        if (e.getSource() == readyButton)
        {
            new NewGame();
            /*if (playerOneCharacterSelected && playerTwoCharacterSelected)
            {
                new NewGame();
            }
            else
            {
                //code to display message that both players must have selected their character
            }*/
        }
    }
}