package edu.gonzaga;

public class Coordinate {
    int [] coords = new int [2];

    public Coordinate(int x, int y){
        coords[0] = x;
        coords[1] = y;
    }

    public int getX(){
        return coords[0];
    }

    public int getY(){
        return coords[1];
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
