
public class King extends Piece
{
    static int count = 0;
    String name = "King";
    private King(String color,int X, int Y)
    {
        super(color,X,Y);
    }
    static public King factory(String color,int X, int Y){
        count++;
        if(count>2){
            throw new Error("You could only initialize 2 King.");
        }
        return new King(color, X, Y);
    }
    public void move(int x, int y)
    {
        
    }
    public String toString(){
        return super.color+this.name.substring(0,2);
    }
}
