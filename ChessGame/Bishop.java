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
        if(count>4){
            throw new Error("You could only initialize 4 Bishops.");
        }
        return new Bishop(color, X, Y);
    }

    public boolean move(int x, int y)
    {
        boolean stepSideways= ((X-x==y-Y) || (X-x==-(y-Y)));
        if(!stepSideways)
        {
            throw new RuntimeException("this operation is illegal!");
        }  
        return true;
    }
    public String toString(){
        return super.color+this.name.substring(0,2);
    }
}