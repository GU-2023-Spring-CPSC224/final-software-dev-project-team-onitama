package edu.gonzaga.BasicGUI;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class BackgroundTest 
{

    public static void main(String[] args)
    {
        Image backgroundImage = new ImageIcon("GameArt/potentialBackgroundWood.png").getImage();
        BackgroundPanel backgroundPanel = new BackgroundPanel(backgroundImage);
        JFrame frame = new JFrame("BackgroundPanel Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(backgroundPanel);
        frame.setVisible(true);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
}
