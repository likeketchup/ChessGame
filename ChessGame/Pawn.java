
public class Pawn extends Piece
{
    static private int count = 0;
    String name = "Pawn";
    private Pawn(Board b,String color,int X, int Y)
    {
        super(b,color,X,Y);
    }
    static public Pawn factory(Board b, String color,int X, int Y){
        count++;
        if(count>16){
            throw new Error("You could only initialize 16 Pawns.");
        }
        return new Pawn(b,color, X, Y);
    }
    public boolean move(int x, int y)
    {
        boolean front=true, left=true ,right=true;
        if(!(gameBoard.getPiece(X+1,Y) instanceof Space))front = false;
        //if(x==X+1&&y==Y+1)
        return true;
    }
    public String toString(){
        return super.color+this.name.substring(0,1);
    }
}
