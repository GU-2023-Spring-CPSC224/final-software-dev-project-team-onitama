package edu.gonzaga.BasicGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import edu.gonzaga.Board;
import edu.gonzaga.Coordinate;

public class BoardButton extends JButton{
    private Board board;
    private Coordinate cord;

    BoardButton(Board b, int x, int y) {
        super("" + b.getBoard()[x][y]);
        board = b;
        cord = new Coordinate(x, y);
        setupCallback();
    }

    public void setupCallback() {
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                // if no piece is selected yet, set piece
                if(!board.isPieceSelected()) {
                    board.setCurPiece(cord);
                    // if a card is also selected, generate the destinations
                    if(board.isCardSelected()) {
                        board.generateDestinations();
                    }
                }
                // if there already is a piece selected
                else {
                    // if a card hasn't been selected, switch cur piece
                    if(!board.isCardSelected()) {
                        board.setCurPiece(cord);
                    }
                    // else if() check for same piece to switch
                    // otherwise, make move
                    else {
                        board.makeMove(cord);
                    }
                }
            }   
        });
    }

}
