public class Rook extends Piece
{
    static int count = 0;
    String name = "Rook";
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
            if(b[y][2].getCast()||b[y][6].getCast()) {
                castling = true;
            }
             else{   if (y > this.Y) {
                    difference = Math.abs(y - this.Y);
                    for (int i = 1; i < difference; i++) {
                        if (b[Y + i][x] instanceof Space == false) {
                            throw new RuntimeException("You cannot do this! Move again!");
                        }
                    }
                } else if (y < this.Y) {
                    difference = Math.abs(y - this.Y);
                    for (int i = 1; i < difference; i++) {
                        if (b[y + i][x] instanceof Space == false) {
                            throw new RuntimeException("You cannot do this! Move again!");
                        }
                    }
                }
                // X block
                if (x > this.X) {
                    difference = Math.abs(x - this.X);
                    for (int i = 1; i < difference; i++) {
                        if (b[y][X + i] instanceof Space == false) {
                            throw new RuntimeException("You cannot do this! Move again!");
                        }
                    }
                } else if (x < this.X) {
                    difference = Math.abs(x - this.X);
                    for (int i = 1; i < difference; i++) {
                        if (b[y][x + i] instanceof Space == false) {
                            throw new RuntimeException("You cannot do this! Move again!");
                        }
                    }
                }
            }
            hasMove = false;
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
        }
        else if(y<Y){
            directY = -1;
            directX = 0;
        }
        else if(x>X){
            directY = 0;
            directX = 1;
        }
        else if(x<X){
            directY = 0;
            directX = -1;
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