
/**
 * Write a description of class Client here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Client
{
    // instance variables - replace the example below with your own
    public static void h(){
        Board a = Board.factory();
        System.out.println(a);
        a.movePiece(0,4,2,5);
        System.out.println(a);
    }
}
