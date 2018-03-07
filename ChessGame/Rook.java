
public class Rook extends Piece
{
    
    String name = "Rook";
    Rook(String color,int X, int Y)
    {
        super(color,X,Y);
    }
    public void move(int x, int y){ 
        boolean outBoard = (x>9&&x<0)&&(y>9&&y<0);
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
