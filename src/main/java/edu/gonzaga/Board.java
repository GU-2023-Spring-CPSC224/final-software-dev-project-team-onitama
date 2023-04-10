package edu.gonzaga;

import java.util.ArrayList;

public class Board {
    private int[][] board = {{3,0,0,0,1},{3,0,0,0,1},{4,0,0,0,2},{3,0,0,0,1},{3,0,0,0,1}};
    private int size;
    private ArrayList<Coordinate> destinations = new ArrayList<Coordinate>();
    private Card currCard;
    private Coordinate currPiece;

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
        if (board[x1][y1] == 1 && board[x2][y2] == 2)
            return false;
        if (board[x1][y1] == 2 && board[x2][y2] == 1)
            return false;
        if (board[x1][y1] == 3 && board[x2][y2] == 4)
            return false;
        if (board[x1][y1] == 4 && board[x2][y2] == 3)
            return false;
        return true;
    }

    public int makeMove(Coordinate destCoord){
        if (checkValidMove(currPiece, destCoord)){
            int piece = board[currPiece.getX()][currPiece.getY()];
            int dest = board[destCoord.getX()][destCoord.getY()];
            board[destCoord.getX()][destCoord.getY()] = piece;
            board[currPiece.getX()][currPiece.getY()] = 0;
            return dest;
        }
        return -1;
    }

    public void generateDestinations(){
        destinations.clear();
        int x1 = currPiece.getX();
        int y1 = currPiece.getY();
        if (board[x1][y1] == 1 || board[x1][y1] == 2 ){
            for (int i = 0; i < currCard.getInvMoves().size(); i++){
                Coordinate temp = new Coordinate(x1 + currCard.getInvMoves().get(i).getX(), y1 + currCard.getInvMoves().get(i).getY());
                destinations.add(temp);
            }
        }
        else if (board[x1][y1] == 3 || board[x1][y1] == 4 ){
            for (int i = 0; i < currCard.getMoves().size(); i++){
                Coordinate temp = new Coordinate(x1 + currCard.getMoves().get(i).getX(), y1 + currCard.getMoves().get(i).getY());
                destinations.add(temp);
            }
        }
        else{
            //error
        }
        //find invalid destinations
        ArrayList<Integer> invalids = new ArrayList<Integer>();
        for (int i = 0; i < destinations.size(); i++){
            if(checkValidMove(currPiece, destinations.get(i)) != true){
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

    public void setCurrCard(Card currCard) {
        this.currCard = currCard;
    }

    public void setCurrPiece(Coordinate currPeice){
        this.currPiece = currPeice;
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
