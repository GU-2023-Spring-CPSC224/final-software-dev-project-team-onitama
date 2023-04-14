package edu.gonzaga;

import org.junit.jupiter.api.Test;
import edu.gonzaga.CardDeck.*;
import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {
    
    @Test
    void testNumTwoDest() {
        Integer expectedValue = 2;
        Card dragon = new DragonCard("Dragon");
        Coordinate piece = new Coordinate(2, 4); //master pawn
        Board board = new Board(5);
        board.setCurCard(dragon);
        board.setCurPiece(piece);
        board.generateDestinations();
        System.out.println(board.getDest());
        assertEquals(expectedValue, board.getNumDest());
    }

    @Test
    void testNumZeroDest() {
        Integer expectedValue = 0;
        Card dragon = new EelCard("Eel");
        Coordinate piece = new Coordinate(0, 4); //bottom left
        Board board = new Board(5);
        board.setCurCard(dragon);
        board.setCurPiece(piece);
        board.generateDestinations();
        assertEquals(expectedValue, board.getNumDest());
    }

    @Test
    void testMoveToEmpty() {
        Boolean expectedValue = true;
        Coordinate piece = new Coordinate(0, 4);
        Coordinate dest = new Coordinate(0, 3);
        Board board = new Board(5);
        Boolean actual = board.checkValidMove(piece, dest);
        assertEquals(expectedValue, actual);
    }
    
    @Test
    void testMovePawnToPawn() {
        Boolean expectedValue = false;
        Coordinate piece = new Coordinate(0, 4);
        Coordinate dest = new Coordinate(1, 4);
        Board board = new Board(5);
        Boolean actual = board.checkValidMove(piece, dest);
        assertEquals(expectedValue, actual);
    }

    @Test
    void testMovePawnToKing() {
        Boolean expectedValue = false;
        Coordinate piece = new Coordinate(0, 4);
        Coordinate dest = new Coordinate(2, 4);
        Board board = new Board(5);
        Boolean actual = board.checkValidMove(piece, dest);
        assertEquals(expectedValue, actual);
    }

    @Test
    void testMovePawnToEnemeyPawn() {
        Boolean expectedValue = true;
        Coordinate piece = new Coordinate(0, 4);
        Coordinate dest = new Coordinate(0, 0);
        Board board = new Board(5);
        Boolean actual = board.checkValidMove(piece, dest);
        assertEquals(expectedValue, actual);
    }

    @Test
    void testMovePawnToEnemeyKing() {
        Boolean expectedValue = true;
        Coordinate piece = new Coordinate(0, 4);
        Coordinate dest = new Coordinate(2, 0);
        Board board = new Board(5);
        Boolean actual = board.checkValidMove(piece, dest);
        assertEquals(expectedValue, actual);
    }

}
