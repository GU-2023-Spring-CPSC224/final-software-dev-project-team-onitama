package edu.gonzaga.BasicGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.io.File;

public class CharacterSelect extends JFrame implements ActionListener
{
    JLabel characterSelectLabel;

    JButton backButton;
    JButton readyButton;
    JButton bluePieceButton;
    JButton blackPieceButton;
    JButton whitePieceButton;
    JButton pinkPieceButton;
    JButton orangePieceButton;
    JButton tealPieceButton;
    JButton purplePieceButton;
    JButton redPieceButton;
    JButton playerOneSelectedButton;
    JButton playerTwoSelectedButton;

    boolean playerOneCharacterSelected = false;
    boolean playerTwoCharacterSelected = false;

    JPanel leftCharacterPanel;
    JPanel rightCharacterPanel;

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

        leftCharacterPanel = createLeftCharacterPanel();
        rightCharacterPanel = createRightCharacterPanel();
        readyButton = createReadyButton();
        backButton = createBackButton();
        playerOneSelectedButton = new JButton();
        playerTwoSelectedButton = new JButton();

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
            for (int i = 0; i < 4; i++)
            {
                if (!characterButtonsArrayList.get(i).equals(selectedButton))
                {
                    characterButtonsArrayList.get(i).setEnabled(false);
                }
            }
        }
        if (playerNum == 2)
        {
            for (int i = 4; i < 8; i++)
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
            for (int i = 0; i < 4; i++)
            {
                if (!characterButtonsArrayList.get(i).equals(selectedButton))
                {
                    characterButtonsArrayList.get(i).setEnabled(true);
                }
            }
        }
        if (playerNum == 2)
        {
            for (int i = 4; i < 8; i++)
            {
                if (!characterButtonsArrayList.get(i).equals(selectedButton))
                {
                    characterButtonsArrayList.get(i).setEnabled(true);
                }
            }
        }
    }

    public JButton createCharacterButtons(String fileName)
    {
        JButton characterButton = new JButton();
        String filePath = new String();
        filePath += "GameArt/" + fileName + ".png";
        File imageFile = new File(filePath);
        ImageIcon characterButtonImageIcon = new ImageIcon(imageFile.getAbsolutePath());
        characterButton.setIcon(characterButtonImageIcon);
        characterButton.addActionListener(this);
        characterButton.putClientProperty("color", fileName);
        return characterButton;
    }

    public JPanel createLeftCharacterPanel()
    {
        JPanel leftCharacterPanel = new JPanel();
        leftCharacterPanel.setBounds(100, 190, 400, 400);
        leftCharacterPanel.setLayout(new GridLayout(2,2));

        bluePieceButton = createCharacterButtons("blue");
        blackPieceButton = createCharacterButtons("black");
        orangePieceButton= createCharacterButtons("orange");
        pinkPieceButton= createCharacterButtons("pink");
        
        leftCharacterPanel.add(bluePieceButton);
        leftCharacterPanel.add(blackPieceButton);
        leftCharacterPanel.add(orangePieceButton);
        leftCharacterPanel.add(pinkPieceButton);

        characterButtonsArrayList.add(bluePieceButton);
        characterButtonsArrayList.add(blackPieceButton);
        characterButtonsArrayList.add(orangePieceButton);
        characterButtonsArrayList.add(pinkPieceButton);

        return leftCharacterPanel;
    }

    public JPanel createRightCharacterPanel()
    {
        JPanel rightCharacterPanel = new JPanel();
        rightCharacterPanel.setBounds(1030, 190, 400, 400);
        rightCharacterPanel.setLayout(new GridLayout(2,2));

        purplePieceButton= createCharacterButtons("purple");
        tealPieceButton= createCharacterButtons("teal");
        redPieceButton= createCharacterButtons("red");
        whitePieceButton = createCharacterButtons("white");

        rightCharacterPanel.add(purplePieceButton);
        rightCharacterPanel.add(tealPieceButton);
        rightCharacterPanel.add(redPieceButton);
        rightCharacterPanel.add(whitePieceButton);

        characterButtonsArrayList.add(purplePieceButton);
        characterButtonsArrayList.add(tealPieceButton);
        characterButtonsArrayList.add(redPieceButton);
        characterButtonsArrayList.add(whitePieceButton);

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

    public void gamePieceButtonClicked(JButton buttonIn, boolean selected, int playerNum)
    {
        if (playerNum == 1)
        {
            if (selected == false)
            {
                buttonIn.setBorder(BorderFactory.createLineBorder(Color.GREEN, 3));
                buttonIn.setBorderPainted(true);
                setButtonsNotClickable(buttonIn, playerNum);
                playerOneCharacterSelected = true;
                playerOneSelectedButton = buttonIn;
            }
            else
            {
                buttonIn.setBorderPainted(false);
                setButtonsClickable(buttonIn, playerNum);
                playerOneCharacterSelected = false;
                playerOneSelectedButton = null;
            }
        }
        if (playerNum == 2)
        {
            if (selected == false)
            {
                buttonIn.setBorder(BorderFactory.createLineBorder(Color.GREEN, 3));
                buttonIn.setBorderPainted(true);
                setButtonsNotClickable(buttonIn, playerNum);
                playerTwoCharacterSelected = true;
                playerTwoSelectedButton = buttonIn;
            }
            else
            {
                buttonIn.setBorderPainted(false);
                setButtonsClickable(buttonIn, playerNum);
                playerTwoCharacterSelected = false;
                playerTwoSelectedButton = null;
            }
        }
    }


    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == backButton)
        {
            dispose();
        }

        if (e.getSource() == bluePieceButton)
        {
            gamePieceButtonClicked(bluePieceButton, playerOneCharacterSelected, 1);
        }
        if (e.getSource() == blackPieceButton)
        {
            gamePieceButtonClicked(blackPieceButton, playerOneCharacterSelected, 1);
        }
        if (e.getSource() == orangePieceButton)
        {
            gamePieceButtonClicked(orangePieceButton, playerOneCharacterSelected, 1);
        }
        if (e.getSource() == pinkPieceButton)
        {
            gamePieceButtonClicked(pinkPieceButton, playerOneCharacterSelected, 1);
        }


        if (e.getSource() == purplePieceButton)
        {
            gamePieceButtonClicked(purplePieceButton, playerTwoCharacterSelected, 2);
        }
        if (e.getSource() == tealPieceButton)
        {
            gamePieceButtonClicked(tealPieceButton, playerTwoCharacterSelected, 2);
        }
        if (e.getSource() == redPieceButton)
        {
            gamePieceButtonClicked(redPieceButton, playerTwoCharacterSelected, 2);
        }
        if (e.getSource() == whitePieceButton)
        {
            gamePieceButtonClicked(whitePieceButton, playerTwoCharacterSelected, 2);
        }


        if (e.getSource() == readyButton)
        {
            if (playerOneCharacterSelected && playerTwoCharacterSelected)
            {
                new NewGame();
                System.out.println((String) playerOneSelectedButton.getClientProperty("color"));
                System.out.println((String) playerTwoSelectedButton.getClientProperty("color"));
            }
            else
            {
                System.out.println("Both players must select a character");
                //code to display message that both players must have selected their character
            }
        }
    }

}