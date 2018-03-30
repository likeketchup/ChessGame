
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
               if((X!=x && Y==y)||(X==x && Y!=y)){
                   //Y block
                   if(y>this.Y){
                       difference = Math.abs(y - this.Y);
                       for(int i = 1;i<difference;i++){
                           if(b[Y+i][x] instanceof Space == false){
                               throw new RuntimeException("You cannot do this! Move again!");
                           }
                       }
                   }
                   else if(y< this.Y){
                       difference = Math.abs(y - this.Y);
                       for(int i = 1;i<difference;i++){
                           if(b[y+i][x] instanceof Space == false){
                               throw new RuntimeException("You cannot do this! Move again!");
                           }
                       }
                   }
                   // X block
                   if(x>this.X){
                       difference = Math.abs(x - this.X);
                       for(int i = 1;i<difference;i++){
                           if(b[y][X+i] instanceof Space == false){
                               throw new RuntimeException("You cannot do this! Move again!");
                           }
                       }
                   }
                   else if(x< this.X){
                       difference = Math.abs(x - this.X);
                       for(int i = 1;i<difference;i++){
                           if(b[y][X+i] instanceof Space == false){
                               throw new RuntimeException("You cannot do this! Move again!");
                           }
                       }
                   }
               }
           }
           //bishop
           else if(stepSideways){
               //bishop
               difference = Math.abs(x-X);
               //right&up
               if(y>Y && x>X){
                   for(int i = 1;i<difference;i++){
                       if(b[Y+i][X+i] instanceof Space == false){
                           throw new RuntimeException("You cannot do this! Move again!");
                       }
                   }
               }
               //left&up
               else if(y>Y && x<X){
                   for(int i = 1;i<difference;i++){
                       if(b[Y+i][X-i] instanceof Space == false){
                           throw new RuntimeException("You cannot do this! Move again!");
                       }
                   }
               }
               //left&down
               else if(y<Y && x<X){
                   for(int i = 1;i<difference;i++){
                       if(b[Y-i][X-i] instanceof Space == false){
                           throw new RuntimeException("You cannot do this! Move again!");
                       }
                   }
               }
               //right&down
               else if(y<Y && x>X){
                   for(int i = 1;i<difference;i++){
                       if(b[Y-i][X+i] instanceof Space == false){
                           throw new RuntimeException("You cannot do this! Move again!");
                       }
                   }
               }
           }
            this.X = x;
            this.Y = y;
            return true;
        }
    
    public String toString(){
        return super.color+this.name.substring(0,2);
    }
}
