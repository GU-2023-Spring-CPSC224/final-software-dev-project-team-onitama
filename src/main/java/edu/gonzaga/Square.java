package edu.gonzaga;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Square {

    char piece;
    int player;

    private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);    

    public Square() {
        piece = '0';
    }


    public void addPropertyChangeListener(PropertyChangeListener listener) {
        this.pcs.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        this.pcs.removePropertyChangeListener(listener);
    }

    private void updatePiece(char newPiece) {
        char oldPiece = this.piece;
        this.piece = newPiece;
        if (newPiece == '0'){
            this.player = 0;
        }
        else if(newPiece == 'R' || newPiece == 'r'){
            this.player = 1;
        }
        else if(newPiece == 'B' || newPiece == 'b'){
            this.player = 2;
        }

        this.pcs.firePropertyChange("squarePiece", oldPiece, newPiece);
    }

    public void setPiece(char newPiece) {
        this.updatePiece(newPiece);
    }

    public char getPiece() {
        return piece;
    }

    @Override
    public String toString() {
        return "" + piece;
    }

}