abstract public class Piece
{   
    String color;
    String name;
    int X;//coordinate
    int Y;//coordinate
    Piece(){}
    Piece( String color, int Y, int X){
        this.color = color;
        this.X = X;
        this.Y = Y;
    }
    abstract public boolean move(int x, int y); //change the coordinate and return the result of the movement.
    public String getXY(){//get the coordinate
        return "("+X+","+Y+")";
    }
    
}
