
public class Pawn extends Piece
{
    static private int count = 0;
    String name = "Pawn";
    private Pawn(String color,int X, int Y)
    {
        super(color,X,Y);
    }
    static public Pawn factory(String color,int X, int Y){
        count++;
        if(count>16){
            throw new Error("You could only initialize 16 Pawns.");
        }
        return new Pawn(color, X, Y);
    }
    public boolean move(int x, int y)
    {
        if((x==X+1&&y==Y)||(x==X+1&&y==Y+1)||(x==X+1&&y==Y+1)){
            this.X = x;
            this.Y = Y;
            return true;
        }
        return false;
    }
    public String toString(){
        return super.color+this.name.substring(0,1);
    }
}
