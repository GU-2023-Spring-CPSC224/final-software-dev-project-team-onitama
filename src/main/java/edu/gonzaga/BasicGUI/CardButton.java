package edu.gonzaga.BasicGUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import edu.gonzaga.Board;
import edu.gonzaga.Hand;
import edu.gonzaga.CardDeck.Card;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;




public class CardButton extends JButton implements PropertyChangeListener{
    private Board board;
    private Hand hand;
    private String name;
    int location;
    Card card;
    

    CardButton(Board b, Hand h, int n) {
        super("" + h.getNames()[n]);
        board = b;
        hand = h;
        location = n;
        name = h.getNames()[n];
        ImageIcon tmp = new ImageIcon("GameArt/" + name + ".png");
        this.setIcon(tmp);
        //this.setBackground(new Color(0, 0, 0, 0)); // Set the background color to transparent
        this.setBorder(null);
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
        switch (location){
            case 0:
                if ("spot0".equals(propertyName)) {
                    //System.out.println(("DieView sees value changed to: " + e.getNewValue()));
                    card = ((Card)e.getNewValue());
                    name = card.getName();
                    this.setIcon(new ImageIcon("GameArt/" + name + ".png"));
                    this.setText(name);
                }
                break;
            case 1:
                if ("spot1".equals(propertyName)) {
                    //System.out.println(("DieView sees value changed to: " + e.getNewValue()));
                    card = ((Card)e.getNewValue());
                    name = card.getName();
                    this.setIcon(new ImageIcon("GameArt/" + name + ".png"));
                    this.setText(name);
                }
                break;
            case 2:
                if ("spot2".equals(propertyName)) {
                    //System.out.println(("DieView sees value changed to: " + e.getNewValue()));
                    card = ((Card)e.getNewValue());
                    name = card.getName();
                    this.setIcon(new ImageIcon("GameArt/" + name + ".png"));
                    this.setText(name);
                }
                break;
            case 3:
                if ("spot3".equals(propertyName)) {
                    //System.out.println(("DieView sees value changed to: " + e.getNewValue()));
                    card = ((Card)e.getNewValue());
                    name = card.getName();
                    this.setIcon(new ImageIcon("GameArt/" + name + ".png"));
                    this.setText(name);
                } 
                break;
            case 4:
                if ("inter".equals(propertyName)) {
                    //System.out.println(("DieView sees value changed to: " + e.getNewValue()));
                    card = ((Card)e.getNewValue());
                    name = card.getName();
                    this.setIcon(new ImageIcon("GameArt/" + name + ".png"));
                    this.setText(name);
                } 
                break;
        }
    }

    public String getName(int i){
        return name;
    }

}
