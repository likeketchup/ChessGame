public class Client
{
    // instance variables - replace the example below with your own
    public static void main(String[] args){
        Board a = Board.factory();
        Player p1 = Player.factory("Eason",a);
        p1.movePiece("B1","A3");//Test the movement of the Knight
        p1.movePiece("D2","D3");//Test the movement of the Pawn
        p1.movePiece("D1","D2");//Test the movement of the King
        p1.movePiece("A3","B5");
        p1.movePiece("C1","A3");//Test the movement of the Bishop
        p1.movePiece("E8","E5");//Test the movement of the Queen
        p1.movePiece("H8","H4");//Test the movement of the Rook
        //System.out.println(a);
        //a.movePiece(1,0,2,0);
        //a.movePiece(1,4,2,5);
        System.out.println(a);
    }
}

