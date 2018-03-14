
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
        if(count>10){
            throw new Error("You could only initialize 4 Knights.");
        }
        return new Knight(color, X, Y);
    }
    public boolean move(int x, int y)
    {
        boolean inBoard = true;
        boolean fowardLeft = true;
        boolean fowardRight = true;
        boolean leftFoward = true;
        boolean leftBackward = true;
        boolean rightFoward = true;
        boolean rightBackward = true;
        boolean backwardLeft = true;
        boolean backwardRight = true;
        /*if(gameBoard.getPiece(X-1,Y+2) instanceof Space)fowardLeft = false;
        if(gameBoard.getPiece(X+1,Y+2) instanceof Space) fowardRight = false;
        if(gameBoard.getPiece(X-2,Y+1) instanceof Space) leftFoward = false;
        if(gameBoard.getPiece(X-2,Y-1) instanceof Space)leftBackward = false;
        if(gameBoard.getPiece(X+2,Y+1) instanceof Space) rightFoward = false;
        if(gameBoard.getPiece(X+2,Y-1) instanceof Space) rightBackward = false;
        if(gameBoard.getPiece(X-1,Y-2) instanceof Space) backwardLeft = false;
        if(gameBoard.getPiece(X+1,Y-2) instanceof Space) backwardRight = false;*/
        if((x>8&&x<0)&&(y>8&&y<0)){
            inBoard = false;
        }
        else if((fowardLeft||fowardRight||leftFoward||leftBackward
                ||rightFoward||rightBackward||backwardLeft||backwardRight)
                &&(inBoard = true)){
            this.X = x;
            this.Y = y;
            return true;
        }
        else{
            System.out.println("Knight can not move to there.");
        }
        return false;//modify latter
    }
    public String toString(){
        return super.color+this.name.substring(0,2);
    }
}
