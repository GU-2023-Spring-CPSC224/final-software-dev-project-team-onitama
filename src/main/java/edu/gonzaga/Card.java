package edu.gonzaga;

import java.util.ArrayList;
import java.util.Arrays;

public class Card {
    private ArrayList<Coordinate> moves = new ArrayList<Coordinate>();
    private ArrayList<Coordinate> invMoves = new ArrayList<Coordinate>();
    public String cardName;

    public Card(String name) {
        this.cardName = name;
        Coordinate move1 = new Coordinate(-2,2);
        Coordinate move2 = new Coordinate(-1,2);
        Coordinate move3 = new Coordinate(0,2);
        Coordinate move4 = new Coordinate(1,2);
        Coordinate move5 = new Coordinate(2,2);

        Coordinate move6 = new Coordinate(-2,1);
        Coordinate move7 = new Coordinate(-1,1);
        Coordinate move8 = new Coordinate(0,1);
        Coordinate move9 = new Coordinate(1,1);
        Coordinate move10 = new Coordinate(2,1);

        Coordinate move11 = new Coordinate(-2,0);
        Coordinate move12 = new Coordinate(-1,0);
        Coordinate move13 = new Coordinate(1,0);
        Coordinate move14 = new Coordinate(2,0);

        Coordinate move15 = new Coordinate(-2,-1);
        Coordinate move16 = new Coordinate(-1,-1);
        Coordinate move17 = new Coordinate(0,-1);
        Coordinate move18 = new Coordinate(1,-1);
        Coordinate move19 = new Coordinate(2,-1);

        Coordinate move20 = new Coordinate(-2,-2);
        Coordinate move21 = new Coordinate(-1,-2);
        Coordinate move22 = new Coordinate(0,-2);
        Coordinate move23 = new Coordinate(1,-2);
        Coordinate move24 = new Coordinate(2,-2);


        switch (cardName) {
            case "tiger":  
                moves.add(move3);
                invMoves.add(move22);
                moves.add(move17);
                invMoves.add(move8);
                break;
            case "crab":
                moves.add(move8);
                invMoves.add(move17);
                moves.add(move11);
                invMoves.add(move14);
                moves.add(move14);
                invMoves.add(move11);
                break;
        }      
    } 
    @Override
    public String toString() {
        String ret = "Card name: ";
        ret += this.cardName;
        ret += "\nmoves : ";
        ret += this.moves.toString();
        ret += "\ninvMoves : ";
        ret += this.invMoves;
        ret += "\n";
        return ret;
    }
}
