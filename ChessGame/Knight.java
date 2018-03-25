public class Knight extends Piece
{
    static int count = 0;
    String name = "Knight";
    private Knight(String color,int Y, int X)
    {
        super(color,Y,X);
    }
    static public Knight factory(String color,int X, int Y){
        count++;
        if(count>4){
            throw new Error("You could only initialize 4 Knights.");
        }
        return new Knight(color, X, Y);
    }
    public boolean move(int y, int x, Piece[][] b)
    {
        if(((Math.abs(x-X)+Math.abs(y-Y))!=3)&&((Math.abs(x-X)*Math.abs(y-Y))!=2)){
            throw new RuntimeException("You cannot do this! Move again!");
        }

        this.X = x;
        this.Y = y;
        return true;
    }
    public String toString(){
        return super.color+this.name.substring(0,2);
    }
}
