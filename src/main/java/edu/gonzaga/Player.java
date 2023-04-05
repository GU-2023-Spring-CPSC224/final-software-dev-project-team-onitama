package edu.gonzaga;

import java.util.ArrayList;

public class Player {
    private ArrayList<Card> cards = new ArrayList<Card>();
    int num;

    public Player(int number , ArrayList<Card> inputCards){
        num = number;
        this.cards = inputCards;
    }

    public Card selectCard(int index){
        Card selectedCard = cards.get(index);
        return selectedCard;
    }

    public void updateCards(ArrayList<Card> inputCards){
        this.cards = inputCards;
    }

    public int getNum(){
        return num;
    }

    @Override
    public String toString() {
        String ret = "";
        ret += this.cards.toString();
        ret += "\n";
        return ret;
    }
}
