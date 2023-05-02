package edu.gonzaga.BasicGUI;

import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame
{
    GameFrame()
    {
        this.setVisible(true);//this makes the frame visible
        //this.setSize(600,600);//sets x & y dimensions
        this.setTitle("Onitama");//setting title
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//what happens when we close the window
        this.setResizable(true);//we can change whether frame may be resized
        ImageIcon image = new ImageIcon("OnitamaLogo.png"); //creates an image icon
        this.setIconImage(image.getImage()); //changes icon of frame
        //this.getContentPane().setBackground(new Color(187,202,131));//changing color of frame

        Image backgroundImage = new ImageIcon("GameArt/potentialBackgroundWood.png").getImage();
        BackgroundPanel backgroundPanel = new BackgroundPanel(backgroundImage);
        this.setContentPane(backgroundPanel);
        
        this.setLayout(null);
        //this.setExtendedState(JFrame.MAXIMIZED_BOTH);

    }
}
