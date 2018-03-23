
public class Queen extends Piece
{   
    static int count = 0;
    String name = "Queen";
    private Queen(String color,int X,int Y)
    {
        super(color,X,Y);
    }
    static public Queen factory(String color,int X, int Y){
        count++;
        if(count>2){
            throw new Error("You could only initialize 2 Queen.");
        }
        return new Queen(color, X, Y);
    }
    public boolean move(int y, int x)
    {
        boolean stepSideways= ((Math.abs(X-x)==Math.abs(y-Y)));
        boolean stepStraightUpDownRightLeft= (X==x&&Y!=y) || (Y==y&&X!=x) ;
        if(!stepSideways && !stepStraightUpDownRightLeft)
        {
            return false;
        }
        this.X = x;
        this.Y = y;
        return true;
    }
    public String toString(){
        return super.color+this.name.substring(0,2);
    }
}
