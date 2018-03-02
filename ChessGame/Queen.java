
public class Queen extends Piece
{
    String name = "Queen";
    Queen(String color,int X,int Y)
    {
        super(color,X,Y);
    }
    public void move(int x, int y)
    {
    }
    public String toString(){
        return super.color+this.name.substring(0,1);
    }
}
