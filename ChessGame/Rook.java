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
    public boolean move(int y, int x, Piece[][] b){
        int difference = 0;
        if((X!=x && Y==y)||(X==x && Y!=y)){
            //Y block
            if(y>this.Y){
                difference = Math.abs(y - this.Y);
                for(int i = Y+1;Y<y;i++){
                    if(b[i][x] instanceof Space == false){
                        throw new RuntimeException("You cannot do this! Move again!");
                    }
                }
            }
            else if(y< this.Y){
                difference = Math.abs(y - this.Y);
                for(int i = y+1;y<Y;i++){
                    if(b[i][x] instanceof Space == false){
                        throw new RuntimeException("You cannot do this! Move again!");
                    }
                }
            }
            // X block
            if(x>this.X){
                difference = Math.abs(x - this.X);
                for(int i = X+1;X<x;i++){
                    if(b[y][i] instanceof Space == false){
                        throw new RuntimeException("You cannot do this! Move again!");
                    }
                }
            }
            else if(x< this.X){
                difference = Math.abs(x - this.X);
                for(int i = x+1;x<X;i++){
                    if(b[y][i] instanceof Space == false){
                        throw new RuntimeException("You cannot do this! Move again!");
                    }
                }
            }
            hasMove = true;
            this.X = x;
            this.Y = y;
            return true;
        }
        else{
            throw new RuntimeException("You cannot do this! Move again!");
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
        return super.color+this.name.substring(0,2);
    }
}