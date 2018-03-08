
public class Rook extends Piece
{

    static int count = 0;
    String name = "Rook";
    private Rook(String color,int X, int Y)
    {
        super(color,X,Y);
    }
    static public Rook factory(String color,int X, int Y){
        count++;
        if(count>2){
            throw new Error("You could only initialize 2.");
        }
        return new Rook(color, X, Y);
    }
    public void move(int x, int y){ 
        boolean outBoard = (x>8&&x<0)&&(y>8&&y<0);
        boolean towardBackward = this.X!=x && this.Y==y;
        boolean leftRight = this.X==x && this.Y!=y;
        if(outBoard){
            System.out.println("can not move out of board!");
        }
        else if(towardBackward||leftRight){
            this.X = x;
            this.Y = y;
        }
        else{
            System.out.println("Rook can not move to there.");
        }
    }
    public String toString(){
        return super.color+this.name.substring(0,1);
    }
}
