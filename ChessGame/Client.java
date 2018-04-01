public class Client
{
    // instance variables - replace the example below with your own
    public static void main(String[] args){
        Board a = Board.factory();
        Player p1 = Player.factory("Eason","White",a);
        p1.movePiece("G7","G5");
        p1.movePiece("F8","H6");
        p1.movePiece("G8","F6");
        p1.movePiece("E8","G8");

        System.out.println(a);
    }
}

