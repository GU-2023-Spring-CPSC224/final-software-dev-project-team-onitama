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

    JFrame mainWindowFrame;
    JPanel upperCardPanel;
    JPanel eastPanel;
    JPanel lowerCardPanel;
    JPanel intermediateCardPanel;
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
        this.mainWindowFrame.setLocation(100,100);
        this.mainWindowFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.mainWindowFrame.setLayout(null);

        this.boardPanel = new JPanel();
        this.upperCardPanel = new JPanel();
        this.eastPanel = new JPanel();
        this.lowerCardPanel = new JPanel();
        this.intermediateCardPanel = new JPanel();

        // Board panel setup
        this.boardPanel = genBoardPanel();
        genCardButtons();
        // tmp card setup
        this.lowerCardPanel = genBottomCardPanel();
        this.intermediateCardPanel.add(cardButtons[4]);
        this.upperCardPanel = genTopCardPanel();

        

        // Window add panels and layout
        mainWindowFrame.add(boardPanel);
        
    }


    // Makes the board
    private JPanel genBoardPanel() {

        JPanel newBoardPanel = new JPanel();
        newBoardPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        newBoardPanel.setBounds(525, 150, 500, 500);

        // making array of buttons
        this.boardButtons = new BoardButton[5][5];
        for(int i=0; i < boardButtons.length; i++)
        {
            for(int j=0; j < boardButtons.length; j++)
            {
                Coordinate temp = new Coordinate(i, j);
                boardButtons[i][j] = new BoardButton(board, temp, pieceIcons);

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