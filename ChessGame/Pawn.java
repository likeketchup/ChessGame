
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
        if(count>6){
            throw new Error("You could only initialize 6 Pawns.");
        }
        return new Pawn(color, X, Y);
    }
    public void move(int x, int y)
    {
    }
    public String toString(){
        return super.color+this.name.substring(0,1);
    }
}
