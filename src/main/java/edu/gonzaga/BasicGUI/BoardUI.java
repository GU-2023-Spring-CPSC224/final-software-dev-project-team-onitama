package edu.gonzaga.BasicGUI;

import edu.gonzaga.CardDeck.Card;
import edu.gonzaga.Board;
import edu.gonzaga.Coordinate;
import edu.gonzaga.Hand;
import edu.gonzaga.Player;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BoardUI {
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


    public BoardUI(){
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
        BoardUI app = new BoardUI();    // Create, then run GUI
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
        this.northPanel = new JPanel();
        this.eastPanel = new JPanel();
        this.southPanel = new JPanel();
        this.westPanel = new JPanel();

        // Board panel setup
        this.boardPanel = genBoardPanel();
        // tmp card setup
        this.southPanel = genCardPanel();
        // Listener setup
        addButtonCallbackHandlers();

        // Window add panels and layout
        mainWindowFrame.getContentPane().add(BorderLayout.CENTER, boardPanel);
        mainWindowFrame.getContentPane().add(BorderLayout.NORTH, northPanel);
        mainWindowFrame.getContentPane().add(BorderLayout.EAST, eastPanel);
        mainWindowFrame.getContentPane().add(BorderLayout.SOUTH, southPanel);
        mainWindowFrame.getContentPane().add(BorderLayout.WEST, westPanel);
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

    //this is a temp way to display cards
    private JPanel genCardPanel() {
        JPanel newCardPanel = new JPanel();
        newCardPanel.setBorder(BorderFactory.createLineBorder(Color.black));


        // making array of buttons
        String[] tmp = hand.getNames();
        this.cardButtons = new JButton[5];
        for(Integer i=0; i < cardButtons.length; i++)
            cardButtons[i] = new JButton("" + tmp[i]);

        for(Integer i=0; i < cardButtons.length; i++)
            newCardPanel.add(cardButtons[i]);

        // Tell panel to make a grid (like a spreadsheet) layout n rows, 2 columns
        newCardPanel.setLayout(new GridLayout(1, 5));    // Making it pretty
        return newCardPanel;
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
                        //checks for empty space
                        if(boardButtons[insideI][insideJ].getText().compareTo("0") == 0) {
                            System.out.println("No piece here");
                        }
                        //if piece, add check for red/blue
                        else{
                            if(pressed == false) {
                                if(isPieceSelected == false) {
                                    System.out.println("You clicked space: [" + insideJ + "," + insideI + "]");
                                    boardButtons[insideI][insideJ].setBackground(Color.GRAY);
                                    Coordinate pieceCoordinate = new Coordinate(insideJ, insideI);
                                    board.setCurPiece(pieceCoordinate);
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
                    }
                });
            }
        }


        for(Integer i=0; i < cardButtons.length; i++) {
            final Integer insideI = i;
            this.cardButtons[insideI].addActionListener(new ActionListener() {
                Boolean pressed = false;
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(pressed == false) {
                        if(isCardSelected == false) {
                            System.out.println("You clicked: " + cardButtons[insideI].getText());
                            cardButtons[insideI].setBackground(Color.GRAY);
                            pressed = true;
                            isCardSelected = true;
                        }
                    }
                    else if(pressed == true) {
                        System.out.println("You un-clicked space: " + cardButtons[insideI].getText());
                        cardButtons[insideI].setBackground(null);
                        pressed = false;
                        isCardSelected = false;
                    }
                }
            });

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