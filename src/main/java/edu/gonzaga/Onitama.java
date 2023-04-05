package edu.gonzaga;

public class Onitama {
    Hand hand;
    Player player1;
    Player player2;

    public Onitama(){
        hand = new Hand(5);
        player1 = new Player(1,hand.getPlayer1Cards());
        player2 = new Player(2,hand.getPlayer2Cards());
        System.out.println(hand);
        System.out.println(player1);
        System.out.println(player2);
        hand.swap(player1.selectCard(1));
        player1.updateCards(hand.getPlayer1Cards());
        System.out.println(hand);
        System.out.println(player1);
        System.out.println(player2);

    }

    public void takeTurn(Player player){
        Card selected = player.selectCard(0); //button press returns 0 for first card 1 for second ect
        hand.swap(selected);
        if (player.getNum() == 1)
            player.updateCards(hand.getPlayer1Cards());
        else if (player.getNum() == 2)
            player.updateCards(hand.getPlayer2Cards());
    }
}
