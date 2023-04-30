package edu.gonzaga.BasicGUI;

import edu.gonzaga.Board;
import edu.gonzaga.Hand;
import edu.gonzaga.Player;

import javax.swing.*;

import java.awt.*;



public class NewGame {
    Hand hand;
    Player player1;
    Player player2;
    Board board;
    String p1color;
    String p2color;
    ImageIcon[] pieceIcons;

    public NewGame(String c1, String c2){
        hand = new Hand(5);
        player1 = new Player(1,hand.getPlayer1Cards());
        player2 = new Player(2,hand.getPlayer2Cards());
        p1color = c1;
        p2color = c2;
        makeIconArray();
        board = new Board(5, hand, pieceIcons);
        BoardUI app = new BoardUI(pieceIcons);    // Create, then run GUI
        app.runGUI();
    }

    private void makeIconArray(){
        pieceIcons = new ImageIcon[6];
        pieceIcons[0] = new ImageIcon("GameArt/boardBackground.png");   // Empty space
        pieceIcons[1] = new ImageIcon("GameArt/" + p1color + ".png");                 // p1 pawn
        pieceIcons[2] = new ImageIcon("GameArt/" + p1color + "King.png");             // p1 king
        pieceIcons[3] = new ImageIcon("GameArt/" + p2color + ".png");                 // p2 pawn
        pieceIcons[4] = new ImageIcon("GameArt/" + p2color + "King.png");             // p2 king
        pieceIcons[5] = new ImageIcon("GameArt/possibleMove.png");      // possible move indicator
        for(int i = 0; i < pieceIcons.length; i++){
            pieceIcons[i] = new ImageIcon(pieceIcons[i].getImage().getScaledInstance(250, 250, Image.SCALE_SMOOTH));
        }
    }

}