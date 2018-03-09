
public class Queen extends Piece
{   
    static int count = 0;
    String name = "Queen";
    private Queen(Board b, String color,int X,int Y)
    {
        super(b,color,X,Y);
    }
    static public Queen factory(Board b, String color,int X, int Y){
        count++;
        if(count>2){
            throw new Error("You could only initialize 2 Queen.");
        }
        return new Queen(b,color, X, Y);
    }
    public boolean move(int x, int y)
    {
        return true;
    }
    public String toString(){
        return super.color+this.name.substring(0,1);
    }
}
