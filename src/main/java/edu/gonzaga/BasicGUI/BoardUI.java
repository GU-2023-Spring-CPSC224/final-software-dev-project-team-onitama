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
    JPanel topCardButtons;
    JPanel eastPanel;
    JPanel bottomCardButtons;
    JPanel intermediateCardPanel;
    JPanel boardPanel;
    JPanel wrapperPanel;
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

        this.boardPanel = new JPanel();
        this.topCardButtons = new JPanel();
        this.eastPanel = new JPanel();
        this.bottomCardButtons = new JPanel();
        this.intermediateCardPanel = new JPanel();


        genBoardPanel();
        genCardButtons();
        this.bottomCardButtons = genBottomCardPanel();
        this.intermediateCardPanel.add(cardButtons[4]);
        this.topCardButtons = genTopCardPanel();
        
        // topCardButtons.setPreferredSize(new Dimension(500,100));
        // bottomCardButtons.setPreferredSize(new Dimension(500,100));
        // intermediateCardPanel.setPreferredSize(new Dimension(250,500));
        // eastPanel.setPreferredSize(new Dimension(250,500));


        mainWindowFrame.getContentPane().add(BorderLayout.CENTER, boardPanel);
        mainWindowFrame.getContentPane().add(BorderLayout.NORTH, topCardButtons);
        mainWindowFrame.getContentPane().add(BorderLayout.EAST, eastPanel);
        mainWindowFrame.getContentPane().add(BorderLayout.SOUTH, bottomCardButtons);
        mainWindowFrame.getContentPane().add(BorderLayout.WEST, intermediateCardPanel);

    }


    // Makes the board
    private void genBoardPanel() 
    {
        boardPanel.setBounds(500, 500, 600, 600);
        boardPanel.setLayout(new GridLayout(5, 5));
        boardPanel.setBorder(BorderFactory.createLineBorder(Color.black));

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


        boardPanel.setLayout(new GridLayout(5,5));
        for(Integer i=0; i < boardButtons.length; i++)
        {
            for(Integer j=0; j < boardButtons.length; j++)
            {
                boardPanel.add(boardButtons[j][i]);
            }
        }
            
    }
    

    // //this is a temp way to display cards
    private void genCardButtons() 
    {
        // making array of buttons
        this.cardButtons = new CardButton[5];
        for(Integer i=0; i < cardButtons.length; i++)
        {
            cardButtons[i] = new CardButton(board, hand, i);
            cardButtons[i].setFocusable(false);
        }

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
        mainWindowFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        mainWindowFrame.setVisible(true);
        System.out.println("Done in GUI app");
    }
    

}