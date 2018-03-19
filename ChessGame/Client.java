public class Client
{
    // instance variables - replace the example below with your own
    public static void main(String[] args){
        Board a = Board.factory();
        Player p1 = Player.factory("Eason",a);
        p1.movePiece("B1","A3");
        p1.movePiece("B2","B3");
        p1.movePiece("D2","D3");
        p1.movePiece("D1","D2");
        //System.out.println(a);
        //a.movePiece(1,0,2,0);
        //a.movePiece(1,4,2,5);
        System.out.println(a);
    }
}

