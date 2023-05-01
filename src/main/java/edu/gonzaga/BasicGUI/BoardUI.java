package edu.gonzaga.BasicGUI;

import edu.gonzaga.CardDeck.Card;
import edu.gonzaga.*;
import javax.swing.*;
import java.awt.*;


public class BoardUI {
    Hand hand;
    Player player1;
    Player player2;
    Board board;
    Boolean isPieceSelected = false;
    Boolean isCardSelected = false;
    Integer playerTurn = 1;


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




    public BoardUI(ImageIcon[] arr){
        hand = new Hand(5);
        player1 = new Player(1,hand.getPlayer1Cards());
        player2 = new Player(2,hand.getPlayer2Cards());
        board = new Board(5, hand, arr);
        pieceIcons = arr;
    }

    public static void main(String [] args) {
        //BoardUI app = new BoardUI();    // Create, then run GUI
        //app.runGUI();
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
        this.mainWindowFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        //this.mainWindowFrame.setLayout(null);

        this.boardPanel = new JPanel();
        this.northPanel = new JPanel();
        this.eastPanel = new JPanel();
        this.southPanel = new JPanel();
        this.westPanel = new JPanel();

        // Board panel setup
       this.boardPanel = genBoardPanel();
        genCardButtons();
        // tmp card setup
        this.southPanel = genBottomCardPanel();
        this.westPanel.add(cardButtons[4]);
        this.northPanel = genTopCardPanel();
        northPanel.setPreferredSize(new Dimension(300, 100));
        eastPanel.setPreferredSize(new Dimension(200, 300));
        southPanel.setPreferredSize(new Dimension(200, 100));
        westPanel.setPreferredSize(new Dimension(300, 300));
        boardPanel.setPreferredSize(new Dimension(600, 600));

        

        mainWindowFrame.add(BorderLayout.NORTH, northPanel);
        mainWindowFrame.add(BorderLayout.EAST, eastPanel);
        mainWindowFrame.add(BorderLayout.SOUTH, southPanel);
        mainWindowFrame.add(BorderLayout.WEST, westPanel);
        mainWindowFrame.add(BorderLayout.CENTER, boardPanel);
        mainWindowFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }


    // Makes the board
    private JPanel genBoardPanel() {

        JPanel newBoardPanel = new JPanel();
        newBoardPanel.setPreferredSize(new Dimension(500,500));
        newBoardPanel.setBorder(BorderFactory.createLineBorder(Color.black));

        // making array of buttons
        this.boardButtons = new BoardButton[5][5];
        for(int i=0; i < boardButtons.length; i++)
        {
            for(int j=0; j < boardButtons.length; j++)
            {
                Coordinate temp = new Coordinate(i, j);
                boardButtons[i][j] = new BoardButton(board, temp, pieceIcons);

                boardButtons[i][j].setFocusable(false);
            }
        }


        //boardPanel.setLayout(new GridLayout(5,5));
        for(Integer i=0; i < boardButtons.length; i++)
            for(Integer j=0; j < boardButtons.length; j++)
                newBoardPanel.add(boardButtons[j][i]);

        // Tell panel to make a grid (like a spreadsheet) layout n rows, 2 columns
        newBoardPanel.setLayout(new GridLayout(5, 5));    // Making it pretty

        // int defaultBoardDimension = 5;
        newBoardPanel.setBounds(525, 150, 600, 600);

        return newBoardPanel;
    }
    

    // //this is a temp way to display cards
    private void genCardButtons() {
        //JPanel newCardPanel = new JPanel();
        //newCardPanel.setBorder(BorderFactory.createLineBorder(Color.black));


        // making array of buttons
        this.cardButtons = new CardButton[5];
        for(Integer i=0; i < cardButtons.length; i++)
        {
            cardButtons[i] = new CardButton(board, hand, i);
            cardButtons[i].setFocusable(false);
        }



        //for(int i=0; i < cardButtons.length; i++)
            //newCardPanel.add(cardButtons[i]);

        // Tell panel to make a grid (like a spreadsheet) layout n rows, 2 columns
        //newCardPanel.setLayout(new GridLayout(1, 5));    // Making it pretty
        //return newCardPanel;
    }

    private JPanel genBottomCardPanel(){
        JPanel newCardPanel = new JPanel();
        newCardPanel.setBorder(BorderFactory.createLineBorder(Color.black));


        for(int i=0; i < 2; i++)
            newCardPanel.add(cardButtons[i]);

        //Tell panel to make a grid (like a spreadsheet) layout n rows, 2 columns
        newCardPanel.setLayout(new GridLayout(1, 2));    // Making it pretty
        return newCardPanel;
    }

    private JPanel genTopCardPanel(){
        JPanel newCardPanel = new JPanel();
        newCardPanel.setBorder(BorderFactory.createLineBorder(Color.black));


        for(int i=2; i < 4; i++)
            newCardPanel.add(cardButtons[i]);

        //Tell panel to make a grid (like a spreadsheet) layout n rows, 2 columns
        newCardPanel.setLayout(new GridLayout(1, 2));    // Making it pretty
        return newCardPanel;
    }


    //runs GUI
    void runGUI() {
        System.out.println("Starting GUI app");
        setupGUI();

        // Run the main window - begins GUI activity
        mainWindowFrame.setVisible(true);
        mainWindowFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        System.out.println("Done in GUI app");
    }
    

}