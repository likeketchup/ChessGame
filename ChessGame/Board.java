import java.util.*;
public class Board
{
    // instance variables - replace the example below with your own
    static int count = 0;
    Piece[][] pieces = new Piece[8][8];
    private int x;
    private static final Board b = new Board();
    private Board(){
        this.pieces[0][0] = Rook.factory("B",0,0);
        this.pieces[0][1] = Knight.factory("B",0,1);
        this.pieces[0][2] = Bishop.factory("B",0,2);
        this.pieces[0][4] = King.factory("B",0,4);
        this.pieces[0][3] = Queen.factory("B",0,3);
        this.pieces[0][5] = Bishop.factory("B",0,5);
        this.pieces[0][6] = Knight.factory("B",0,6);
        this.pieces[0][7] = Rook.factory("B",0,7);
        for(int i=0;i<8;i++){
            pieces[1][i] = Pawn.factory("B",1,i);
        }
        for(int i=2;i<6;i++){
            for(int j = 0;j<8;j++){
                this.pieces[i][j] = new Space();
            }
        }
        for(int i = 0;i<8;i++){
            pieces[6][i] = Pawn.factory("W",6,i);
        }
        this.pieces[7][0] = Rook.factory("W",7,0);
        this.pieces[7][1] = Knight.factory("W",7,1);
        this.pieces[7][2] = Bishop.factory("W",7,2);
        this.pieces[7][4] = King.factory("W",7,4);
        this.pieces[7][3] = Queen.factory("W",7,3);
        this.pieces[7][5] = Bishop.factory("W",7,5);
        this.pieces[7][6] = Knight.factory("W",7,6);
        this.pieces[7][7] = Rook.factory("W",7,7);
    }
    
    public String toString(){
        return printBoard();
    }
    private String printBoard(){
        String board = new String();
        for(int i = 0;i<8;i++){
            board = board+(i+1);
            for(int j = 0;j<8;j++){
                board = board+"  "+pieces[i][j];
            }
            board = board+"\n";
        }
        board = board+"   A    B    C    D    E    F    G    H";
        return board;
    }
    static public Board getBoard(){
        return b;
    }
    static public Board factory(){
        count++;
        if(count>1){
            throw new RuntimeException("you can only initialize one board");
        }  
        return b;
    }
    public boolean movePiece(int y1, int x1, int y2,int x2){
        if(pieces[y1][x1] instanceof Space){
            throw new RuntimeException("there is not have any piece in your appointed coordinate.");
            
        }//prevent player to move the space.
        if(pieces[y1][x1].color==pieces[y2][x2].color){
            throw new RuntimeException("you cannot eat the piece in the same side!");
            
        }//prevent player eat the same color piece.
        if(pieces[y1][x1].move(y2,x2, this.pieces)){
            if(pieces[y2][x2] instanceof King) return true;
            pieces[y2][x2]=pieces[y1][x1];

            pieces[y1][x1]= new Space();
            //System.out.println("Move Success!");

        }
        /*if((pieces[x1][y1] instanceof King)&&(pieces[x1][y1].move(x1-2,y2, this.pieces))
                &&(pieces[x1][1] instanceof Space)
                &&(pieces[x1][2] instanceof Space)
                &&(pieces[x1][3] instanceof Space)
                ){
            //pieces[x1][0].setXY(x1,3);
            pieces[x1][3]=pieces[x1][0];
            pieces[x1][0]=new Space();
            //System.out.println("Move Success");
        }
        if((pieces[x2][y2]==pieces[x1+2][y2])&&(pieces[x1][y1].move(x1+2,y2, this.pieces))
                &&(pieces[x1][5] instanceof Space)
                &&(pieces[x1][6] instanceof Space)
                ){
            //pieces[x1][7].setXY(x1,5);
            pieces[x1][7]=pieces[x1][5];
            pieces[x1][7]=new Space();
            //System.out.println("Move Success");
        }*/
        return false;
    }

    public Piece getPiece(int x,int y){
        return pieces[x][y];
    }



    public String getPieceColor(int y, int x)
    {
        return pieces[y][x].color;

    }
}
