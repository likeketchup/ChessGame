abstract public class Piece
{   
    String color;
    String name;
    Board gameBoard;
    int X;//coordinate
    int Y;//coordinate
    Piece(){}
    Piece(Board b, String color, int X, int Y){
        this.gameBoard = b;
        this.color = color;
        this.X = X;
        this.Y = Y;
    }
    Piece( String color, int X, int Y){
        this.color = color;
        this.X = X;
        this.Y = Y;
    }
    abstract public boolean move(int x, int y); //change the coordinate and return the result of the movement.
    public String getXY(){//get the coordinate
        return "("+X+","+Y+")";
    }
    
}
