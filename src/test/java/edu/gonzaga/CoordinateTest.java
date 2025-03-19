package edu.gonzaga;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class CoordinateTest {
  @Test
  void testGetX() {
    Integer expectedValue = 2;
    Coordinate coord = new Coordinate(2, 4); // master pawn
    assertEquals(expectedValue, coord.getX());
  }

  @Test
  void testGetY() {
    Integer expectedValue = 4;
    Coordinate coord = new Coordinate(2, 4); // master pawn
    assertEquals(expectedValue, coord.getY());
  }

  @Test
  void testToString() {
    String expectedValue = "(2,4)";
    Coordinate coord = new Coordinate(2, 4); // master pawn
    assertEquals(expectedValue, coord.toString());
  }
}
