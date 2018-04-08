public class Client
{

    // instance variables - replace the example below with your own
    public static void main(String[] args){
        Reader ct = new Reader();
        try{
            ct.setBr("/Users/happy_family/IdeaProjects/ChessGame/TestFiles/Test.txt");
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
                    e.printStackTrace();
                }
                System.out.println(a);
            }
        }
        catch (Exception e){
            System.out.println(e);
            e.getStackTrace();
        }

    }
}

