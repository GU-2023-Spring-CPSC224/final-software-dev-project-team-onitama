package edu.gonzaga;

import edu.gonzaga.CardDeck.Card;
import edu.gonzaga.CardDeck.DragonCard;

import javax.swing.*;


public class Onitama {
    Hand hand;
    Player player1;
    Player player2;
    Board board;


    /*
     * Swing Stuff
     */
    JFrame mainWindowFrame;
    JPanel northPanel;
    JPanel eastPanel;
    JPanel southPanel;
    JPanel westPanel;
    JPanel boardPanel;
    JButton[][] boardButtons;
    JButton[] cardButtons;
    Boolean isPieceSelected = false;
    Boolean isCardSelected = false;


    public Onitama(){
        hand = new Hand(5);
        player1 = new Player(1,hand.getPlayer1Cards());
        player2 = new Player(2,hand.getPlayer2Cards());
        board = new Board(5, hand);
        Card dragon = new DragonCard("Dragon");
        board.setCurCard(dragon);


        /* 
        System.out.println(hand);
        System.out.println(player1);
        System.out.println(player2);
        hand.swap(player1.selectCard(1));
        player1.updateCards(hand.getPlayer1Cards());
        System.out.println(hand);
        System.out.println(player1);
        System.out.println(player2);
        */
    }

    public static void main(String [] args) {
        Onitama app = new Onitama();    // Create, then run GUI
    }

    public void takeTurn(){
        Card selected = player1.selectCard(0); //button press returns 0 for first card 1 for second ect
        hand.swap(selected);
        board.setCurCard(selected);
        //need coordinate of piece to be moved
        Coordinate temp = new Coordinate(2, 4);
        board.setCurPiece(temp);
        board.generateDestinations();
        System.out.println(board.toString());
        //display generated Destinations
        board.chooseDestination(0);
        System.out.println(board.toString());
        player1.updateCards(hand.getPlayer1Cards());
        /* 
        if (player.getNum() == 1)
            player.updateCards(hand.getPlayer1Cards());
        else if (player.getNum() == 2)
            player.updateCards(hand.getPlayer2Cards());
        */
    }

    // GUI Setup
    
    
}
