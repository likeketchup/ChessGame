public class Client
{
    // instance variables - replace the example below with your own
    public static void main(String[] args){
        Board a = Board.factory();
        Player p1 = Player.factory("Eason",a);
        p1.movePiece("H1","H3");//Test the movement of the Knight
        p1.movePiece("H3","H4");//Test the movement of the Black Pawn
        p1.movePiece("A8","A4");//Test the movement of the White Pawn move first time.
        //p1.movePiece("E1","D2");//Test the movement of the King
        p1.movePiece("A4","D4");
        //p1.movePiece("C1","E3");//Test the movement of the Bishop
        //p1.movePiece("D8","D6");//Test the movement of the Queen
        p1.movePiece("H8","H5");//Test the movement of the Rook
        p1.movePiece("A1","A5");
        //System.out.println(a);
        //a.movePiece(1,0,2,0);
        //a.movePiece(1,4,2,5);
        System.out.println(a);
    }
}

