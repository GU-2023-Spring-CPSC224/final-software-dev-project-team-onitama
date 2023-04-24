package edu.gonzaga.BasicGUI;

import java.awt.event.*;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

JButton newGameButton;
JButton instructionsButton;
JButton optionsButton;
JButton quitButton;
GameFrame frame;
JPanel startMenuPanel;
JLabel gameTitleLabel;

public class QuitDialog extends JFrame {
    
    public QuitDialog() {
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setLayout(null);


        JButton quitButton = new JButton("Quit");
        quitButton.setBounds(1410, 725, 100, 50);
        quitButton.setText("Quit");
        quitButton.setFocusable(false);
        quitButton.setFont(new Font("MV Boli", Font.BOLD, 15));
        quitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                int confirm = JOptionPane.showConfirmDialog(QuitDialog.this,
                    "Are you sure you want to quit?",
                    "Confirm Quit", JOptionPane.YES_NO_OPTION);

                if (confirm == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });
        getContentPane().add(quitButton);
        this.setBounds(500,500,250,250);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent event) {
                int confirm = JOptionPane.showConfirmDialog(QuitDialog.this,
                    "Are you sure you want to quit?",
                    "Confirm Quit", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new QuitDialog();
    }
    
}


//////////////////////////////////////////////////////////////////////////////////


// package edu.gonzaga.BasicGUI;

// import javax.swing.*;
// import java.awt.*;
// import java.awt.event.ActionEvent;
// import java.awt.event.ActionListener;

// public class GameMenu extends JFrame implements ActionListener
// {
//     JButton newGameButton;
//     JButton instructionsButton;
//     JButton optionsButton;
//     JButton quitButton;
//     GameFrame frame;
//     JPanel startMenuPanel;
//     JLabel gameTitleLabel;

//     public static void main(String[] args)
//     {
//         new GameMenu();
//     }

//     GameMenu()
//     {
//         frame = new GameFrame();
//         gameTitleLabel = new JLabel("Onitama: A two player strategy game");
//         startMenuPanel = new JPanel();
//         newGameButton = new JButton();
//         instructionsButton = new JButton();
//         optionsButton = new JButton();
//         quitButton = new JButton();
//         frame.setExtendedState(JFrame.MAXIMIZED_BOTH);


//         /*ImageIcon gameTitleImage = new ImageIcon("OnitamaLettering.png");
//         gameTitleLabel.setIcon(gameTitleImage);*/
//         gameTitleLabel.setBounds(570, 100, 400, 100);
//         gameTitleLabel.setFont(new Font("MV Boli", Font.BOLD, 20));
//         gameTitleLabel.setBorder(BorderFactory.createLineBorder(Color.BLUE, 3));


//         startMenuPanel.setBounds(570, 220, 400, 700);
//         startMenuPanel.setBackground(Color.lightGray);


//         newGameButton.setBounds(600, 250, 350, 60);
//         newGameButton.setText("New Game");
//         newGameButton.setFont(new Font("MV Boli", Font.BOLD, 15));
//         newGameButton.setFocusable(false);
//         newGameButton.addActionListener(this);
//         newGameButton.setForeground(Color.RED);

//         instructionsButton.setBounds(600, 320, 350, 60);
//         instructionsButton.setText("How to play");
//         instructionsButton.setFont(new Font("MV Boli", Font.BOLD, 15));
//         instructionsButton.setFocusable(false);
//         instructionsButton.addActionListener(this);
//         instructionsButton.setForeground(Color.RED);

//         optionsButton.setBounds(600, 390, 350, 60);
//         optionsButton.setText("Options");
//         optionsButton.setFont(new Font("MV Boli", Font.BOLD, 15));
//         optionsButton.setFocusable(false);
//         optionsButton.addActionListener(this);
//         optionsButton.setForeground(Color.RED);

//         quitButton.setBounds(600, 460, 350, 60);
//         quitButton.setText("Quit");
//         quitButton.setFont(new Font("MV Boli", Font.BOLD, 15));
//         quitButton.setFocusable(false);
//         quitButton.addActionListener(this);
//         quitButton.setForeground(Color.RED);


//         //startMenuPanel.add(newGameButton);
//         frame.add(gameTitleLabel);
//         //frame.add(startMenuPanel);
//         frame.add(newGameButton);
//         frame.add(optionsButton);
//         frame.add(instructionsButton);
//         frame.add(quitButton);
//     }


//     @Override
//     public void actionPerformed(ActionEvent e)
//     {
//         if (e.getSource() == newGameButton)
//         {
//             CharacterSelect c = new CharacterSelect();
//         }
//         if (e.getSource() == instructionsButton)
//         {
//             HowToPlay h = new HowToPlay();
//         }
//         if (e.getSource() == optionsButton)
//         {
//             Options s = new Options();
//         }
//         if (e.getSource() == quitButton)
//         {
//             System.exit(0);
//         }
//     }
// }