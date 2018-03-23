public class Rook extends Piece
{
    static int count = 0;
    String name = "Rook";
    private Rook(String color,int X, int Y)
    {
        super(color,X,Y);
    }
    static public Rook factory(String color,int X, int Y) {
        count++;
        if (count > 4) {
            throw new Error("You could only initialize 4.");
        }
        return new Rook(color, X, Y);
    }
    public boolean move(int y, int x){
        if((X!=x && Y==y)||(X==x && Y!=y)){
            hasMove = true;
            this.X = x;
            this.Y = y;
            return true;
        }
        System.out.println(x);
        System.out.println(y);
        return false;


    }
    public boolean hasMove(){
        if(hasMove==false){return true;}
        return false;
    }
    public boolean getHasMove(boolean hasMove){
        this.hasMove=hasMove;
        return hasMove;
    }
    public String toString(){
        return super.color+this.name.substring(0,2);
    }
}