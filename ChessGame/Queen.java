
public class Queen extends Piece
{   
    static int count = 0;
    String name = "Queen";
    private Queen(String color,int X,int Y)
    {
        super(color,X,Y);
    }
    static public Queen factory(String color,int X, int Y){
        //count++;
        if(count>2){
            throw new Error("You could only initialize 2 Queen.");
        }
        return new Queen(color, X, Y);
    }
    
    public boolean move(int y, int x, Piece[][] b)
    {
           boolean stepSideways= ((Math.abs(X-x)==Math.abs(y-Y)));
           boolean stepStraightUpDownRightLeft= (X==x&&Y!=y)||(Y==y&&X!=x) ;
           if(!stepSideways && !stepStraightUpDownRightLeft)
           {
               throw new RuntimeException("You cannot do this! Move again!");
           }
           int difference = 0;
           //rook
           if(stepStraightUpDownRightLeft){
               checkStraightBlock(y,x,b);
           }
           //bishop
           else if(stepSideways){
               checkSideBlock(y,x,b);
           }
           this.X = x;
           this.Y = y;
           return true;
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
    
    private void checkSideBlock(int m, int n, Piece[][] b){
        int y =m;
        int x =n;
        int directY = 1;
        int directX = 1;
        int difference = Math.abs(x-X);
        if(y>Y && x<X){
            directY = 1;
            directX = -1;
        }
        else if(y<Y && x<X){
            directY = -1;
            directX = -1;
        }
        else if(y<Y && x>X){
            directY = -1;
            directX = 1;
        }
        for(int i = 1;i<difference;i++){
            if(b[Y+i*directY][X+i*directX] instanceof Space == false){
                throw new RuntimeException("You cannot do this! Move again!");
            }
        }
    }
    
    public String toString(){
        return super.color+this.name.substring(0,2);
    }
}
