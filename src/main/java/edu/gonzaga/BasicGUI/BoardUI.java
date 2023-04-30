package edu.gonzaga.BasicGUI;

import edu.gonzaga.CardDeck.Card;
import edu.gonzaga.*;

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
    CardButton[] cardButtons;
    ImageIcon[] pieceIcons;
    Boolean isPieceSelected = false;
    Boolean isCardSelected = false;
    Integer playerTurn = 1;



    public BoardUI(ImageIcon[] arr){
        hand = new Hand(5);
        player1 = new Player(1,hand.getPlayer1Cards());
        player2 = new Player(2,hand.getPlayer2Cards());
        board = new Board(5, hand, arr);
        pieceIcons = arr;
    }

    public BoardUI(){
        hand = new Hand(5);
        player1 = new Player(1,hand.getPlayer1Cards());
        player2 = new Player(2,hand.getPlayer2Cards());
        board = new Board(5, hand);
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
        //Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        //this.mainWindowFrame.setPreferredSize(screenSize);
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
        //addButtonCallbackHandlers();
        

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

        ImageIcon background = new ImageIcon("boardBackground.png");
        // making array of buttons
        this.boardButtons = new BoardButton[5][5];
        String tmp;
        for(int i=0; i < boardButtons.length; i++)
        {
            for(int j=0; j < boardButtons.length; j++)
            {
                Coordinate temp = new Coordinate(i, j);
                boardButtons[i][j] = new BoardButton(board, temp, pieceIcons);
                tmp = boardButtons[i][j].getText();
                switch(tmp){
                case "0":
                    boardButtons[i][j].setIcon(pieceIcons[0]);
                    break;
                case "r":
                    boardButtons[i][j].setIcon(pieceIcons[1]);
                    break;
                case "R":
                    boardButtons[i][j].setIcon(pieceIcons[2]);
                    break;
                case "b":
                    boardButtons[i][j].setIcon(pieceIcons[3]);
                    break;
                case "B":
                    boardButtons[i][j].setIcon(pieceIcons[4]);
                    break;
                }
                //boardButtons[i][j].setIcon(background);
                boardButtons[i][j].setFocusable(false);
            }
        }


        boardPanel.setLayout(new GridLayout(5,5));
        for(Integer i=0; i < boardButtons.length; i++)
            for(Integer j=0; j < boardButtons.length; j++)
                newBoardPanel.add(boardButtons[j][i]);

        // Tell panel to make a grid (like a spreadsheet) layout n rows, 2 columns
        newBoardPanel.setLayout(new GridLayout(5, 5));    // Making it pretty
        return newBoardPanel;

    }
    

    // //this is a temp way to display cards
    private JPanel genCardPanel() {
        JPanel newCardPanel = new JPanel();
        newCardPanel.setBorder(BorderFactory.createLineBorder(Color.black));


        // making array of buttons
        this.cardButtons = new CardButton[5];
        for(Integer i=0; i < cardButtons.length; i++)
        {
            cardButtons[i] = new CardButton(board, hand, i);
            cardButtons[i].setFocusable(false);
        }



        for(int i=0; i < cardButtons.length; i++)
            newCardPanel.add(cardButtons[i]);

        // Tell panel to make a grid (like a spreadsheet) layout n rows, 2 columns
        newCardPanel.setLayout(new GridLayout(1, 5));    // Making it pretty
        return newCardPanel;
    }


    /* 
    private void addButtonCallbackHandlers() {
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
    */
    //runs GUI
    void runGUI() {
        System.out.println("Starting GUI app");
        setupGUI();

        // Run the main window - begins GUI activity
        mainWindowFrame.setVisible(true);
        System.out.println("Done in GUI app");
    }
    

}