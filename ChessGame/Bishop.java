
public class Bishop extends Piece
{
    static int count = 0;
    String name = "Bishop";
    private Bishop(String color,int X, int Y)
    {
        super(color,X,Y);
    }
    static public Bishop factory(String color,int X, int Y){
        count++;
        if(count==2){
            throw new Error("You could only initialize 2 Bishops.");
        }
        return new Bishop(color, X, Y);
    }

    public void move(int x, int y)
    {
    }
    public String toString(){
        return super.color+this.name.substring(0,1);
    }
}
