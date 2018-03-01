import java.util.*;
/**
 * Write a description of class borad here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class borad
{
    // instance variables - replace the example below with your own
    ArrayList[][] pieces = new ArrayList[8][8];
    private int x;
    borad(){
        this.pieces[0][0] = new Rook();
        this.pieces[0][1] = new Knight();
        this.pieces[0][2] = new bishop();
        this.pieces[0][3] = new King();
        this.pieces[0][4] = new Queen();
        this.pieces[0][5] = new Bishop();
        this.pieces[0][6] = new Knight();
        this.pieces[0][7] = new Rook();
        for(int i=0;i<8;i++){
            pieces[1][i] = new Pawn();
        }
        for(int i=2;i<6;i++){
            for(int j = 0;j<8;j++){
                this.pieces[i][j] = "0";
            }
        }
        for(int i = 0;i<8;i++){
            pieces[6][i] = new Pawn();
        }
        this.pieces[7][0] = new Rook();
        this.pieces[7][1] = new Knight();
        this.pieces[7][2] = new bishop();
        this.pieces[7][3] = new King();
        this.pieces[7][4] = new Queen();
        this.pieces[7][5] = new Bishop();
        this.pieces[7][6] = new Knight();
        this.pieces[7][7] = new Rook();
    }
    
    public String toString(){
        
        return "board";
    }
    private String printBorad(){
        String borad = new String();
        for(int i = 0;i<8;i++){
            borad = borad+i;
            for(int j = 0;j<8;j++){
                borad = borad+" "+pieces[i][j];
            }
            borad = borad+"\n";
        }
        borad = borad+"  A B C D E F G H";
        return borad;
    }

}
