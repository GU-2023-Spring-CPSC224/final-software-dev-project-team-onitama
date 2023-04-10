package edu.gonzaga;

import java.util.ArrayList;

import edu.gonzaga.CardDeck.Card;

public class Board {
    private char[][] board = {{'b','0','0','0','r'},{'b','0','0','0','r'},{'B','0','0','0','R'},{'b','0','0','0','r'},{'b','0','0','0','r'}};
    private int size;
    private ArrayList<Coordinate> destinations = new ArrayList<Coordinate>();
    private Card curCard;
    private Coordinate curPiece;

    public Board(int size){
        this.size = size;
    }
    public boolean checkValidMove(Coordinate pieceCoord, Coordinate destCoord){
        int x1 = pieceCoord.getX();
        int y1 = pieceCoord.getY();
        int x2 = destCoord.getX();
        int y2 = destCoord.getX();
        //no movement
        if (pieceCoord == destCoord)
            return false;
        //out of bounds
        if (x1 > size || x1 < 0)
            return false;
        if (y1 > size || y1 < 0)
            return false;
        if (x2 > size || x2 < 0)
            return false;
        if (y2 > size || y2 < 0)
            return false;
        //same team
        if (board[x1][y1] == board[x2][y2])
            return false;
        if (board[x1][y1] == 'b' && board[x2][y2] == 'B')
            return false;
        if (board[x1][y1] == 'B' && board[x2][y2] == 'b')
            return false;
        if (board[x1][y1] == 'r' && board[x2][y2] == 'R')
            return false;
        if (board[x1][y1] == 'R' && board[x2][y2] == 'r')
            return false;
        return true;
    }

    public int makeMove(Coordinate destCoord){
        if (checkValidMove(curPiece, destCoord)){
            char piece = board[curPiece.getX()][curPiece.getY()];
            char dest = board[destCoord.getX()][destCoord.getY()];
            board[destCoord.getX()][destCoord.getY()] = piece;
            board[curPiece.getX()][curPiece.getY()] = '0';
            return dest;
        }
        return -1;
    }

    public void generateDestinations(){
        destinations.clear();
        int x1 = curPiece.getX();
        int y1 = curPiece.getY();
        if (board[x1][y1] == 'b' || board[x1][y1] == 'B' ){
            for (int i = 0; i < curCard.getInvMoves().size(); i++){
                Coordinate temp = new Coordinate(x1 + curCard.getInvMoves().get(i).getX(), y1 + curCard.getInvMoves().get(i).getY());
                destinations.add(temp);
            }
        }
        else if (board[x1][y1] == 'r' || board[x1][y1] == 'R' ){
            for (int i = 0; i < curCard.getMoves().size(); i++){
                Coordinate temp = new Coordinate(x1 + curCard.getMoves().get(i).getX(), y1 + curCard.getMoves().get(i).getY());
                System.out.println(temp.getX() + ", " + temp.getY());
                destinations.add(temp);
            }
        }
        else{
            System.out.println("Choose a different spot?");
        }
        //find invalid destinations
        ArrayList<Integer> invalids = new ArrayList<Integer>();
        for (int i = 0; i < destinations.size(); i++){
            if(checkValidMove(curPiece, destinations.get(i)) != true){
                invalids.add(0,i);
            }
        }
        //remove invalid destinations
        for (int i = 0; i < invalids.size(); i++){
            destinations.remove(invalids.get(i));
        }
    }

    public void chooseDestination(int choice){
        makeMove(destinations.get(choice));
    }

    public void setCurCard(Card curCard) {
        this.curCard = curCard;
    }

    public void setCurPiece(Coordinate curPiece){
        this.curPiece = curPiece;
    }

    public Integer getNumDest() {
        return destinations.size();
    }

    @Override
    public String toString() {
        String ret = "";
        for (int i = 0; i < board.length; i++){
            ret+= "\n";
            for (int j = 0; j <board[i].length; j++){
                ret += board[j][i];
                ret += ",";
            }
        }
        return ret;
    }
}
