package edu.gonzaga;

import java.util.ArrayList;

public class Player {
    private ArrayList<Card> cards = new ArrayList<Card>();

    public Player(ArrayList<Card> inputCards){
        this.cards = inputCards;
    }

    public Card selectCard(int index){
        Card selectedCard = cards.get(index);
        return selectedCard;
    }

    public void updateCards(ArrayList<Card> inputCards){
        this.cards = inputCards;
    }

    @Override
    public String toString() {
        String ret = "";
        ret += this.cards.toString();
        ret += "\n";
        return ret;
    }
}
