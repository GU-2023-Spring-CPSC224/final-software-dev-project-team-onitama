package edu.gonzaga;

import java.awt.Panel;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class observationTesting {
    public static void main(String[] args) {
    
        Square test = new Square();
        JFrame frame = new JFrame();
        //BoardButton button = new BoardButton(test);
        frame.setTitle("Yahtzee game by Crandall");
        frame.setSize(600, 400);
        frame.setLocation(200,200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //button.setSquareToView(test);
        //test.setPiece('k');
        //frame.add(button);
        //button.setVisible(true);
        frame.setVisible(true);
        //System.out.println(test.toString());
        // Your code here. Good luck!
    }
}
