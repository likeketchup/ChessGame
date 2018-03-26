public class Client
{
    // instance variables - replace the example below with your own
    public static void main(String[] args){
        Board a = Board.factory();
        Player p1 = Player.factory("Eason","white",a);
        p1.movePiece("A7","A5");
        System.out.println(a);
    }
}

