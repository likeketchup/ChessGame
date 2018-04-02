abstract public class Piece
{   
    String color;
    boolean hasMove = true;
    boolean castling = false;
    int X;//coordinate
    int Y;//coordinate
    Piece(){}
    Piece(String color, int Y, int X){
        this.color = color;
        this.X = X;
        this.Y = Y;
    }
    public boolean getCast(){
        return castling;
    }

    public boolean getHasMove(){
        return hasMove;
    }
    abstract public boolean move(int x, int y, Piece[][] b); //change the coordinate and return the result of the movement.
    public String getXY(){//get the coordinate
        return "("+X+","+Y+")";
    }
    
}
