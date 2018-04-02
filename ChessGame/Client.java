import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
public class Client
{
    private BufferedReader br;
    void setBr(String path) throws Exception{
        File file = new File(path);
        br = new BufferedReader(new FileReader(file));
    }
    public String getNext() throws Exception{
        return br.readLine();
    }
    // instance variables - replace the example below with your own
    public static void main(String[] args){
        Client ct = new Client();
        try{
            ct.setBr("/Users/happy_family/IdeaProjects/ChessGame/TestFiles/Knight.txt");
        }
        catch (Exception e){
            System.out.println(e);
        }
        String move1  = "";
        String move2  = "";
        Board a = Board.factory();
        Player p1 = Player.factory("Eason","White",a);
        try{
            while(((move1 = ct.getNext())!=null)&&((move2 = ct.getNext())!=null)){
                System.out.println(move1);
                System.out.println(move2);
                try{
                    p1.movePiece(move1,move2);
                }
                catch (Exception e){
                    System.out.println(e);
                }
                System.out.println(a);
            }
        }
        catch (Exception e){
            System.out.println(e);
        }

    }
}

