import java.util.*;
/**
 * Write a description of class borad here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
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
        this.pieces[0][3] = King.factory("B",0,3);
        this.pieces[0][4] = Queen.factory("B",0,4);
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
        this.pieces[7][3] = King.factory("W",7,3);
        this.pieces[7][4] = Queen.factory("W",7,4);
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
    public void movePiece(int x1, int y1, int x2,int y2){
        if(pieces[x1][y1] instanceof Space){
            throw new RuntimeException("there is not have any piece in your appointed coordinate.");
            
        }//prevent player to move the space.
        if(pieces[x1][y1].color==pieces[x2][y2].color){
            throw new RuntimeException("you cannot eat the piece in the same side!");
            
        }//prevent player eat the same color piece.
        if(pieces[x1][y1] instanceof Pawn){
          boolean isBlack = true;
          if(pieces[x1][y1].color == "W") isBlack = false;
          int dir = 1;
          if(isBlack == false) dir = -1;
          boolean front=true, OBleft=true ,OBright=true;
          if(!(pieces[x1+dir][y1] instanceof Space))front = false;
          if (pieces[x1+dir][y1+dir] instanceof Space) OBright = false;
          if (pieces[x1-dir][y1+dir] instanceof Space) OBleft = false;
          if(((x2==x1+dir&&y2==y1)&&front == true)||((x2==x1+dir&&y2==y1+dir)&&OBright == true)||((x2==x1+dir&&y2==y1+dir)&&OBleft == true)){
            pieces[x2][y2]=pieces[x1][y1];
            pieces[x1][y1].move(x2,y2);
            pieces[x1][y1]= new Space();  
            System.out.println("Move Success!");
          }
          else {
              throw new RuntimeException("wrong");
              //System.out.println(front);
          }
          return;
        }
        if(pieces[x1][y1].move(x2,y2)){
            pieces[x2][y2]=pieces[x1][y1];
            pieces[x1][y1]= new Space();
            System.out.println("Move Success!");
            return ;
        }
    }
    public Piece getPiece(int x,int y){
        return pieces[x][y];
    }
}
