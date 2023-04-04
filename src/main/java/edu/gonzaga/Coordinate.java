package edu.gonzaga;

public class Coordinate {
    int [] coords = new int [2];

    public Coordinate(int x, int y){
        coords[0] = x;
        coords[1] = y;
    }

    @Override
    public String toString() {
        String ret = "(";
        ret += this.coords[0];
        ret += ",";
        ret += this.coords[1];
        ret += ")";
        return ret;
    }
}
