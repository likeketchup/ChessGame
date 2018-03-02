import java.util.*;
/**
 * Write a description of class borad here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Borad
{
    // instance variables - replace the example below with your own
    Piece[][] pieces = new Piece[8][8];
    private int x;
    Borad(){
        this.pieces[0][0] = new Rook("B",0,0);
        this.pieces[0][1] = new Knight("B",0,1);
        this.pieces[0][2] = new Bishop("B",0,2);
        this.pieces[0][3] = new King("B",0,3);
        this.pieces[0][4] = new Queen("B",0,4);
        this.pieces[0][5] = new Bishop("B",0,5);
        this.pieces[0][6] = new Knight("B",0,6);
        this.pieces[0][7] = new Rook("B",0,7);
        for(int i=0;i<8;i++){
            pieces[1][i] = new Pawn("B",1,i);
        }
        for(int i=2;i<6;i++){
            for(int j = 0;j<8;j++){
                this.pieces[i][j] = new Space();
            }
        }
        for(int i = 0;i<8;i++){
            pieces[6][i] = new Pawn("W",6,i);
        }
        this.pieces[7][0] = new Rook("W",7,0);
        this.pieces[7][1] = new Knight("W",7,1);
        this.pieces[7][2] = new Bishop("W",7,2);
        this.pieces[7][3] = new King("W",7,3);
        this.pieces[7][4] = new Queen("W",7,4);
        this.pieces[7][5] = new Bishop("W",7,5);
        this.pieces[7][6] = new Knight("W",7,6);
        this.pieces[7][7] = new Rook("W",7,7);
    }
    
    public String toString(){
        
        return printBorad();
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
        borad = borad+"  A  B  C  D  E  F  G  H";
        return borad;
    }

}
