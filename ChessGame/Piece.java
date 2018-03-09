//programmed by toma 2/28/2018
abstract public class Piece
{   
    static int count = 0;
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
        count++;
        if(count>64){
            throw new Error("Out of 32 pieces!");
        }
    }
    Piece( String color, int X, int Y){
        this.color = color;
        this.X = X;
        this.Y = Y;
        count++;
        if(count>64){
            throw new Error("Out of 32 pieces!");
        }
    }
    abstract public boolean move(int x, int y); //change the coordinate and return the result of the movement.
    public String getXY(){//get the coordinate
        return "("+X+","+Y+")";
    }
    
}
