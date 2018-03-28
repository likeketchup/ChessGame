
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
    public boolean move(int y, int x, Piece[][] b)
    {
        boolean move = false;
        int dy = Math.abs(y-Y);
        int dx = Math.abs(x-X);
        int dir = 1;
        if(this.color.equals("W")) dir = -1;
        boolean front=true, OBleft=true ,OBright=true, fisrtTime = false;
        if((b[Y+dir*2][X] instanceof Space)&&!hasMove) fisrtTime = true;
        if(!(b[Y+dir][X] instanceof Space))front = false;
        if((dir==-1 && X!=0)||(dir==1&&X!=7))
            if (b[Y+dir][X+dir] instanceof Space) OBright = false;
        if((dir==1 && X!=7)||(dir==-1&&X!=0))
            if (b[Y-dir][X+dir] instanceof Space) OBleft = false;
        if(((y==Y+dir&&x==X)&&front)||((y==Y+dir&&x==X+dir)&&OBright||((y==Y+dir&&x==X+dir)&&OBleft)||(y==Y+dir*2&&x==X&&fisrtTime&&front))){
            this.X = x;
            this.Y = y;
            //System.out.println("Move Success!");
            return true;
        }
        throw new RuntimeException("You cannot do this! Move again!");

    }
    public String toString(){
        return super.color+this.name.substring(0,2);
    }
}
