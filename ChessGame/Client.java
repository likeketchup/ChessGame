
/**
 * Write a description of class Client here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Client
{
    // instance variables - replace the example below with your own
    static public void main(){
        Board a = Board.factory();
        System.out.println(a);
        a.movePiece(2,5,2,6);
        System.out.println(a);
        
    }
}
