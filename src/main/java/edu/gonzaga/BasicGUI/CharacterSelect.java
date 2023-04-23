package edu.gonzaga.BasicGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CharacterSelect extends JFrame implements ActionListener
{
    JLabel characterSelectLabel;
    JButton backButton;
    JButton readyButton;

    JButton playerOneCharacterA;
    JButton playerOneCharacterB;

    JButton playerTwoCharacterA;
    JButton playerTwoCharacterB;

    boolean playerOneCharacterSelected = false;
    boolean playerTwoCharacterSelected = false;

    JPanel leftCharacterPanel;
    JPanel rightCharacterPanel;

   String selectedBlueImage;
   String selectedRedImage;


    ArrayList<JButton> characterButtonsArrayList;

    public static void main(String[] args)
    {
        new CharacterSelect();
    }

    CharacterSelect()
    {
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
        
        characterButtonsArrayList = new ArrayList<JButton>();
        selectedBlueImage = new String();
        selectedRedImage = new String();

        leftCharacterPanel = createLeftCharacterPanel();
        rightCharacterPanel = createRightCharacterPanel();
        readyButton = createReadyButton();
        backButton = createBackButton();

        characterSelectLabel = new JLabel();
        characterSelectLabel.setBounds(640, 100, 400, 100);
        characterSelectLabel.setFont(new Font("MV Boli", Font.BOLD, 30));
        characterSelectLabel.setText("Character Select");


        this.add(leftCharacterPanel);
        this.add(rightCharacterPanel);
        this.add(characterSelectLabel);
        this.add(backButton);
        this.add(readyButton);
    }

    public void setButtonsNotClickable(JButton selectedButton, int playerNum)
    {
        if (playerNum == 1)
        {
            for (int i = 0; i < 2; i++)
            {
                if (!characterButtonsArrayList.get(i).equals(selectedButton))
                {
                    characterButtonsArrayList.get(i).setEnabled(false);
                }
            }
        }
        if (playerNum == 2)
        {
            for (int i = 2; i < 4; i++)
            {
                if (!characterButtonsArrayList.get(i).equals(selectedButton))
                {
                    characterButtonsArrayList.get(i).setEnabled(false);
                }
            }
        }
    }

    public void setButtonsClickable(JButton selectedButton, int playerNum)
    {
        if (playerNum == 1)
        {
            for (int i = 0; i < 2; i++)
            {
                if (!characterButtonsArrayList.get(i).equals(selectedButton))
                {
                    characterButtonsArrayList.get(i).setEnabled(true);
                }
            }
        }
        if (playerNum == 2)
        {
            for (int i = 2; i < 4; i++)
            {
                if (!characterButtonsArrayList.get(i).equals(selectedButton))
                {
                    characterButtonsArrayList.get(i).setEnabled(true);
                }
            }
        }
    }

    public JPanel createLeftCharacterPanel()
    {
        JPanel leftCharacterPanel = new JPanel();
        leftCharacterPanel.setBounds(100, 290, 400, 200);
        leftCharacterPanel.setLayout(new GridLayout(0,2));

        playerOneCharacterA = new JButton();
        ImageIcon playerOneCharacterAImage = new ImageIcon("blueA.png");
        playerOneCharacterA.setIcon(playerOneCharacterAImage);
        playerOneCharacterA.addActionListener(this);

        playerOneCharacterB = new JButton();
        ImageIcon playerOneCharacterBImage = new ImageIcon("blueB.png");
        playerOneCharacterB.setIcon(playerOneCharacterBImage);
        playerOneCharacterB.addActionListener(this);
    
        leftCharacterPanel.add(playerOneCharacterA);
        leftCharacterPanel.add(playerOneCharacterB);

        characterButtonsArrayList.add(playerOneCharacterA);
        characterButtonsArrayList.add(playerOneCharacterB);

        return leftCharacterPanel;
    }

    public JPanel createRightCharacterPanel()
    {
        JPanel rightCharacterPanel = new JPanel();
        rightCharacterPanel.setBounds(1030, 290, 400, 200);
        rightCharacterPanel.setLayout(new GridLayout(0,2));

        playerTwoCharacterA = new JButton();
        ImageIcon playerTwoCharacterAImage = new ImageIcon("redA.png");
        playerTwoCharacterA.setIcon(playerTwoCharacterAImage);
        playerTwoCharacterA.addActionListener(this);

        playerTwoCharacterB = new JButton();
        ImageIcon playerTwoCharacterBImage = new ImageIcon("redB.png");
        playerTwoCharacterB.setIcon(playerTwoCharacterBImage);
        playerTwoCharacterB.addActionListener(this);

        rightCharacterPanel.add(playerTwoCharacterA);
        rightCharacterPanel.add(playerTwoCharacterB);

        characterButtonsArrayList.add(playerTwoCharacterA);
        characterButtonsArrayList.add(playerTwoCharacterB);

        return rightCharacterPanel;
    }

    public JButton createReadyButton()
    {
        readyButton = new JButton();
        readyButton.setText("Ready!");
        readyButton.setFont(new Font("MV Boli", Font.BOLD, 15));
        readyButton.setBounds(690, 350, 150, 75);
        readyButton.addActionListener(this);
        readyButton.setFocusable(false);
        readyButton.setForeground(Color.BLACK);

        return readyButton;
    }

    public JButton createBackButton()
    {
        backButton = new JButton();
        backButton.setText("Back");
        backButton.setFont(new Font("MV Boli", Font.BOLD, 15));
        backButton.setBounds(1410, 725, 100, 50);
        backButton.addActionListener(this);
        backButton.setFocusable(false);
        backButton.setForeground(Color.BLACK);
        
        return backButton;
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
            if (playerOneCharacterSelected == false)
            {
                playerOneCharacterA.setBorder(BorderFactory.createLineBorder(Color.GREEN, 3));
                playerOneCharacterA.setBorderPainted(true);
                playerOneCharacterSelected = true;
                setButtonsNotClickable(playerOneCharacterA, 1);
                selectedBlueImage = "blueA";
            }
            else
            {
                playerOneCharacterA.setBorderPainted(false);
                playerOneCharacterSelected = false;
                setButtonsClickable(playerOneCharacterA, 1);
            }
        }

        if (e.getSource() == playerOneCharacterB)
        {
            if (playerOneCharacterSelected == false)
            {
                playerOneCharacterB.setBorder(BorderFactory.createLineBorder(Color.GREEN, 3));
                playerOneCharacterB.setBorderPainted(true);
                playerOneCharacterSelected = true;
                setButtonsNotClickable(playerOneCharacterB, 1);
                selectedBlueImage = "blueB";
            }
            else
            {
                playerOneCharacterB.setBorderPainted(false);
                playerOneCharacterSelected = false;
                setButtonsClickable(playerOneCharacterB, 1);
            }
        }

        if (e.getSource() == playerTwoCharacterA)
        {
            if (playerTwoCharacterSelected == false)
            {
                playerTwoCharacterA.setBorder(BorderFactory.createLineBorder(Color.GREEN, 3));
                playerTwoCharacterA.setBorderPainted(true);
                playerTwoCharacterSelected = true;
                setButtonsNotClickable(playerTwoCharacterA, 2);
                selectedRedImage = "redA";
            }
            else
            {
                playerTwoCharacterA.setBorderPainted(false);
                playerTwoCharacterSelected = false;
                setButtonsClickable(playerTwoCharacterA, 2);
            }
        }
        
        if (e.getSource() == playerTwoCharacterB)
        {
            if (playerTwoCharacterSelected == false)
            {
                playerTwoCharacterB.setBorder(BorderFactory.createLineBorder(Color.GREEN, 3));
                playerTwoCharacterB.setBorderPainted(true);
                playerTwoCharacterSelected = true;
                setButtonsNotClickable(playerTwoCharacterB, 2);
                selectedRedImage = "redB";
            }
            else
            {
                playerTwoCharacterB.setBorderPainted(false);
                playerTwoCharacterSelected = false;
                setButtonsClickable(playerTwoCharacterB, 2);
            }
        }  


        if (e.getSource() == readyButton)
        {
            if (playerOneCharacterSelected && playerTwoCharacterSelected)
            {
                new NewGame();
                System.out.println(selectedBlueImage);
                System.out.println(selectedRedImage);
            }
            else
            {
                System.out.println("Both players must select a character");
                //code to display message that both players must have selected their character
            }
        }
    }
}