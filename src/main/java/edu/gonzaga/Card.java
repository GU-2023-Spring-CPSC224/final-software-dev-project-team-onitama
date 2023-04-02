package edu.gonzaga;

import java.util.ArrayList;
import java.util.Arrays;

public class Card {
    private ArrayList<int[]> moves = new ArrayList<int[]>();
    private ArrayList<int[]> invMoves = new ArrayList<int[]>();
    private ArrayList<String> cards = new ArrayList<>(Arrays.asList("tiger","crab"));

    public Card(int index) {
        String cardString = cards.get(index);
        int[] move1 = {-2,2};
        int[] move2 = {-1,2};
        int[] move3 = {0,2};
        int[] move4 = {1,2};
        int[] move5 = {2,2};

        int[] move6 = {-2,1};
        int[] move7 = {-1,1};
        int[] move8 = {0,1};
        int[] move9 = {1,1};
        int[] move10 = {2,1};

        int[] move11 = {-2,0};
        int[] move12 = {-1,0};
        int[] move13 = {1,0};
        int[] move14 = {2,0};

        int[] move15 = {-2,-1};
        int[] move16 = {-1,-1};
        int[] move17 = {0,-1};
        int[] move18 = {1,-1};
        int[] move19 = {2,-1};

        int[] move20 = {-2,-2};
        int[] move21 = {-1,-2};
        int[] move22 = {0,-2};
        int[] move23 = {1,-2};
        int[] move24 = {2,-2};

        switch (cardString) {
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

    
}
