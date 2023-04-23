package edu.gonzaga.BasicGUI;

import javax.swing.*;

import edu.gonzaga.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

public class BoardButton extends JButton implements PropertyChangeListener {
    
    Square squareToView;
    String text;
    Board board;
    Coordinate cord;
    boolean border;
    boolean selected;

    public BoardButton(Board b, Coordinate c) {
        super("");
        board = b;
        cord = c;
        squareToView = board.getSquare(cord);
        text = squareToView.toString();
        this.setText(text);
        squareToView.addPropertyChangeListener(this::propertyChange);
        addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                        board.boardButtonPressed(cord);
                }
            }
        );
    }

/* 
    void setSquareToView(Square newSquareToView) {
        squareToView = newSquareToView;
        this.setText(squareToView.toString());
        squareToView.addPropertyChangeListener(this::propertyChange);
        addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    squareToView.setPiece('4');
                }
            }
        );
    }

    */

    public void propertyChange(PropertyChangeEvent e) {
        String propertyName = e.getPropertyName();
        if ("squarePiece".equals(propertyName)) {
            //System.out.println(("DieView sees value changed to: " + e.getNewValue()));
            text = e.getNewValue().toString();
            this.setText(text);
        }
        if ("possible".equals(propertyName)) {
            border = ((boolean)e.getNewValue());
            if(border){
                this.setBackground(Color.BLACK);
            }
            else{
                this.setBackground(null);
            }
        }
        if ("selected".equals(propertyName)) {
            selected = ((boolean)e.getNewValue());
            if(selected){
                this.setBackground(Color.BLUE);
            }
            else{
                this.setBackground(null);
            }
        }
    }

}
