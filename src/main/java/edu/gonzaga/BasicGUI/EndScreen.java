package edu.gonzaga.BasicGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class EndScreen extends JFrame implements ActionListener{
    
    int victor;
    JButton quitButton;
    GameFrame frame;
    JPanel endPanel;
    JLabel endTitleLabel;


    public static void main(String[] args)
    {
        new EndScreen(0);
    }

    public EndScreen(int num)
    {
        victor = num;
        setupGUI();
    }


    private void setupGUI(){
        frame = new GameFrame();
        endTitleLabel = new JLabel("Player " + victor + " Wins!");
        endPanel = new JPanel();
        quitButton = new JButton();
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);


        /*ImageIcon gameTitleImage = new ImageIcon("OnitamaLettering.png");
        gameTitleLabel.setIcon(gameTitleImage);*/
        endTitleLabel.setBounds(570, 115, 400, 100);
        endTitleLabel.setFont(new Font("MV Boli", Font.BOLD, 40));
        endTitleLabel.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));
        endTitleLabel.setBackground(Color.white);


        quitButton.setBounds(600, 460, 350, 60);
        quitButton.setText("Quit");
        quitButton.setFont(new Font("MV Boli", Font.BOLD, 15));
        quitButton.setFocusable(false);
        quitButton.addActionListener(this);
        quitButton.setForeground(Color.BLACK);


        frame.add(endTitleLabel);
        frame.add(quitButton);

        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == quitButton)
        {
            System.exit(0);
        }
    }
}

