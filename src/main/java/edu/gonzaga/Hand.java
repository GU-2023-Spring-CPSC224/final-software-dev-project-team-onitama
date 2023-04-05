package edu.gonzaga;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class Hand {
    private ArrayList<Card> cards = new ArrayList<Card>();
    private ArrayList<String> cardNames = new ArrayList<>(Arrays.asList("tiger","crab", "monkey", "boar", "ox"));
    private ArrayList<Card> player1Cards = new ArrayList<Card>();
    private ArrayList<Card> player2Cards = new ArrayList<Card>();
    private Card intermediate;

    public Hand (int size){
        Random random = new Random();
        int j = 0; 
        ArrayList<Integer> temp = new ArrayList<Integer>();
        while (j < size){
            int x = random.nextInt(cardNames.size());
            if(temp.contains(x) != true){
                temp.add(x);
                j++;
            }
        }
        System.out.println(temp);
        for (int i = 0; i < size; i++){
            cards.add(new Card(cardNames.get(temp.get(i))));
        }
        //for (int i = 0; i < size; i++){
        //    int x = random.nextInt(cardNames.size());
        //    cards.add(new Card(cardNames.get(x)));
        //}
        for (int i = 0; i < cards.size()/2; i++){
            player1Cards.add(cards.get(i));
        }
        for (int i = cards.size()/2; i < cards.size()-1; i++){
            player2Cards.add(cards.get(i));
        }
        intermediate = cards.get(cards.size()-1);
    }

    private void update(){
        for (int i = 0; i < cards.size()/2; i++){
            player1Cards.set(i,cards.get(i));
        }
        for (int i = cards.size()/2; i < cards.size()-1; i++){
            player2Cards.set(i-cards.size()/2,cards.get(i));
        }
        intermediate = cards.get(cards.size()-1);
    }

    public void swap(Card playerCard){
        int location = -1;
        for(int i = 0; i < cards.size() - 1; i++){
            if (playerCard == cards.get(i)){
                location = i;
            }
        }
        Card temp = cards.get(location);
        cards.set(location, cards.get(cards.size() - 1));
        cards.set(cards.size() - 1, temp);
        update();
    }

    public ArrayList<Card> getPlayer1Cards(){
        return player1Cards;
    }

    public ArrayList<Card> getPlayer2Cards(){
        return player2Cards;
    }

    @Override
    public String toString() {
        String ret = "";
        ret += this.cards.toString();
        ret += "\n";
        return ret;
    }
}