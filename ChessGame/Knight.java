public class Knight extends Piece
{
    static int count = 0;
    String name = "Knight";
    private Knight(String color,int X, int Y)
    {
        super(color,X,Y);
    }
    static public Knight factory(String color,int X, int Y){
        count++;
        if(count>4){
            throw new Error("You could only initialize 4 Knights.");
        }
        return new Knight(color, X, Y);
    }
    public boolean move(int x, int y)
    {
        if(   (x==X-1&&y==Y+2)||
              (x==X+1&&y==Y+2)||
              (x==X-2&&y==Y+1)||
              (x==X-2&&y==Y-1)||
              (x==X+2&&y==Y+1)||
              (x==X+2&&y==Y-1)||
              (x==X-1&&y==Y-2)||
              (x==X+1&&y==Y-2)
           ){
            this.X = x;
            this.Y = y;
            return true;
        }
        return false;
    }
    public String toString(){
        return super.color+this.name.substring(0,2);
    }
}
