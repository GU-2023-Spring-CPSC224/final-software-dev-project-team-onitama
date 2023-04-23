package edu.gonzaga.BasicGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import edu.gonzaga.Board;
import edu.gonzaga.Hand;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;




public class CardButton extends JButton implements PropertyChangeListener{
    private Board board;
    private Hand hand;
    private String name;
    int location;
    

    CardButton(Board b, Hand h, int n) {
        super("" + h.getNames()[n]);
        board = b;
        hand = h;
        location = n;
        name = h.getNames()[n];
        hand.addPropertyChangeListener(this::propertyChange);
        addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    board.cardButtonPressed(location);
                }
            }
        );
        //setupCallback();
    }

    public void setupCallback() {
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                // if no piece is selected yet, set piece
                if(!board.isCardSelected()) {
                    board.setCurCard(hand.getCardByName(name));
                    // if a card is also selected, generate the destinations
                    if(board.isPieceSelected()) {
                        board.generateDestinations();
                    }
                }
                // if there already is a piece selected
                else {
                    // if a card hasn't been selected, switch cur piece
                    if(!board.isPieceSelected()) {
                        board.setCurCard(hand.getCardByName(name));
                    }
                    // else if() check for same card to switch
                }
            }   
        });
    }

    public void propertyChange(PropertyChangeEvent e) {
        String propertyName = e.getPropertyName();
        if ("hand".equals(propertyName)) {
            //System.out.println(("DieView sees value changed to: " + e.getNewValue()));
            hand = ((Hand)e.getNewValue());
            name = hand.getNames()[location];
        }
    }
}
