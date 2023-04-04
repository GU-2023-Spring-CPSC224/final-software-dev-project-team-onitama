package edu.gonzaga;

public class Onitama {
    Hand hand;
    Player player1;
    Player player2;

    public Onitama(){
        hand = new Hand(5);
        player1 = new Player(hand.getPlayer1Cards());
        player2 = new Player(hand.getPlayer2Cards());
        System.out.println(hand);
        System.out.println(player1);
        System.out.println(player2);
        hand.swap(player1.selectCard(0));
        player1.updateCards(hand.getPlayer1Cards());
        System.out.println(hand);
        System.out.println(player1);
        System.out.println(player2);

    }

    public void takeTurn(Player player){
        Card sele
    }
}
