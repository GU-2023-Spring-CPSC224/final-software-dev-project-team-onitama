package edu.gonzaga;
import org.junit.jupiter.api.Test;
import edu.gonzaga.CardDeck.*;
import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {
    
    @Test
    void testDefaultTot() {
        Integer expectedValue = 4;
        Card dragon = new DragonCard("Dragon");
        Coordinate piece = new Coordinate(4, 2); //master pawn
        Board board = new Board(5);
        board.setCurCard(dragon);
        board.setCurPiece(piece);
        board.generateDestinations();
        System.out.println("Default value should be 4");
        assertEquals(expectedValue, board.getNumDest());
    }
    
}
