public class Rook extends Piece
{
    static int count = 0;
    private String name = "Rook";
    private Rook(String color,int X, int Y)
    {
        super(color,X,Y);
    }
    static public Rook factory(String color,int X, int Y) {
        //count++;
        if (count > 4) {
            throw new Error("You could only initialize 4.");
        }
        return new Rook(color, X, Y);
    }
    public boolean move(int y, int x, Piece[][] b){
        int difference = 0;
        if((X!=x && Y==y)||(X==x && Y!=y)){
            checkStraightBlock(y,x,b);
            hasMove = true;
            //Y block
            this.X = x;
            this.Y = y;
            return true;
        }
        else{
            throw new RuntimeException("You cannot do this! Move again!");
        }

    }
    public void checkStraightBlock(int m,int n, Piece[][] b){
        int y = m;
        int x = n;
        int directY = 1;
        int directX = 1;
        int difference = 0;
        if(y>Y){
            directY = 1;
            directX = 0;
            difference = Math.abs(y-Y);
        }
        else if(y<Y){
            directY = -1;
            directX = 0;
            difference = Math.abs(y-Y);
        }
        else if(x>X){
            directY = 0;
            directX = 1;
            difference = Math.abs(x-X);
        }
        else if(x<X){
            directY = 0;
            directX = -1;
            difference = Math.abs(x-X);
        }
        for(int i = 1;i<difference;i++){
             if(b[Y+i*directY][X+i*directX] instanceof Space == false){
                 throw new RuntimeException("You cannot do this! Move again!");
             }
        }
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
        return color+this.name.substring(0,2);
    }
}