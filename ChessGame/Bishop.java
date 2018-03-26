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

    public boolean move(int y, int x, Piece[][] b)
    {
        boolean stepSideways= (Math.abs(x-X)==Math.abs(y-Y));
        if(!stepSideways)
        {
            throw new RuntimeException("You cannot do this! Move again!");
        }
        int difference = Math.abs(x-X);
        //right&up
        if(y>Y && x>X){
            for(int i = 1;i<difference;i++){
                if(b[Y+i][X+i] instanceof Space == false){
                    throw new RuntimeException("You cannot do this! Move again!");
                }
            }
        }
        else if(y>Y && x<X){
            for(int i = 1;i<difference;i++){
                if(b[Y+i][X-i] instanceof Space == false){
                    throw new RuntimeException("You cannot do this! Move again!");
                }
            }
        }
        else if(y<Y && x<X){
            for(int i = 1;i<difference;i++){
                if(b[Y-i][X-i] instanceof Space == false){
                    throw new RuntimeException("You cannot do this! Move again!");
                }
            }
        }
        else if(y<Y && x>X){
            for(int i = 1;i<difference;i++){
                if(b[Y-i][X+i] instanceof Space == false){
                    throw new RuntimeException("You cannot do this! Move again!");
                }
            }
        }
        this.X=x;
        this.Y=y;
        return true;
    }
    public String toString(){
        return super.color+this.name.substring(0,2);
    }
}