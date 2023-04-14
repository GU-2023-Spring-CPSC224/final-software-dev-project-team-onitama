package edu.gonzaga;

import edu.gonzaga.CardDeck.Card;
import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class Onitama {
    Hand hand;
    Player player1;
    Player player2;
    Board board;


    /*
     * Swing Stuff
     */
    JFrame mainWindowFrame;
    JPanel boardPanel;
    JButton[][] boardButtons;
    Boolean isPieceSelected = false;


    public Onitama(){
        hand = new Hand(5);
        player1 = new Player(1,hand.getPlayer1Cards());
        player2 = new Player(2,hand.getPlayer2Cards());
        board = new Board(5);


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
        app.runGUI();        
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
    void setupGUI() {
        this.mainWindowFrame = new JFrame("Simple GUI Onitama");
        this.mainWindowFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.mainWindowFrame.setSize(400, 400);
        this.mainWindowFrame.setLocation(100,100);
        
        this.boardPanel = new JPanel();

        // Board panel setup
        this.boardPanel = genBoardPanel();
        // Listener setup
        addButtonCallbackHandlers();

        // Window add panels and layout
        mainWindowFrame.getContentPane().add(BorderLayout.CENTER, boardPanel);
        mainWindowFrame.pack();
    }
    
    // Makes the board
    private JPanel genBoardPanel() {
        JPanel newBoardPanel = new JPanel();
        newBoardPanel.setBorder(BorderFactory.createLineBorder(Color.black));


        // making array of buttons
        char[][] tmp = board.getBoard();
        this.boardButtons = new JButton[5][5];
        for(Integer i=0; i < boardButtons.length; i++)
            for(Integer j=0; j < boardButtons.length; j++)
                boardButtons[i][j] = new JButton("" + tmp[i][j]);

        boardPanel.setLayout(new GridLayout(5,5));
        for(Integer i=0; i < boardButtons.length; i++)
            for(Integer j=0; j < boardButtons.length; j++)
                newBoardPanel.add(boardButtons[j][i]);

        // Tell panel to make a grid (like a spreadsheet) layout n rows, 2 columns
        newBoardPanel.setLayout(new GridLayout(5, 5));    // Making it pretty
        return newBoardPanel;
    }

    private void addButtonCallbackHandlers() {

        /*  
         * This looks scary but its just the set up for the button listeners
         * If you guys can do it better pls do, but this should actually work 
         * Quite well
         */ 
        for(Integer i=0; i < boardButtons.length; i++) {
            for(Integer j=0; j < boardButtons.length; j++) {
                final Integer insideI = i;
                final Integer insideJ = j;
                this.boardButtons[insideI][insideJ].addActionListener(new ActionListener() {
                    Boolean pressed = false;
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if(pressed == false) {
                            if(isPieceSelected == false) {
                                System.out.println("You clicked space: [" + insideJ + "," + insideI + "]");
                                boardButtons[insideI][insideJ].setBackground(Color.GRAY);
                                pressed = true;
                                isPieceSelected = true;
                            }
                        }
                        else if(pressed == true) {
                            System.out.println("You un-clicked space: [" + insideJ + "," + insideI + "]");
                            boardButtons[insideI][insideJ].setBackground(null);
                            pressed = false;
                            isPieceSelected = false;
                        }
                    }
                });
            }   
        }


    }

    //runs GUI
    void runGUI() {
        System.out.println("Starting GUI app");
        setupGUI();

        // Run the main window - begins GUI activity
        mainWindowFrame.setVisible(true);
        System.out.println("Done in GUI app");
    }
    
}
