import java.util.Scanner;

public class FileInputClient {
    static Scanner scn=new Scanner(System.in);
    static Client fileReader = new Client();
    public static void main(String[] args){
        try{
            fileReader.setBr("/Users/happy_family/IdeaProjects/ChessGame/TestFiles/Test.txt");
        }
        catch (Exception e){
            System.out.println(e);
        }
        System.out.println("This is a Chess Game develop by team SuperChess");
        System.out.println("Main Developer: Toma Chen, Eason Lu, Wendy Tan, Fiona Liu");
        try {
            Board b=Board.factory();
            System.out.println("A board has been create!");
            Player whitePlayer=Player.factory("P1","White",b);
            Player blackPlayer=Player.factory("P2","Black",b);
            System.out.println("Two players have been create!");
            System.out.println("Game Start!");
            System.out.println("Game Board Spreading!");
            System.out.println("\n");
            System.out.println(b);
            System.out.println("---------------------------------------");
            while(!(fileReader.nextStep())){
                if(playerAction(whitePlayer)) return ;
                System.out.println(b);
                if(playerAction(blackPlayer)) return ;
                System.out.println(b);

            }
        }
        catch (Exception e){
            System.out.println(e);
        }


    }
    private static boolean playerAction(Player p){


        String previous = "";
        String aim = "";
        try{
            System.out.println("Is the time for "+p.getColor()+" Player "+p.getName()+" move the piece");
            System.out.println("Which piece do you want to move: ");
            if ((previous = fileReader.getNext())!=null){
                System.out.println("Where do you want this piece to go: ");
                aim = fileReader.getNext();
                System.out.println(previous);
                System.out.println(aim);
                if(p.movePiece(previous, aim)){
                    System.out.println(p.getName()+" Win. Game End");
                    return true;
                }
                int pawnChange[] = checkPawn(p.getBoard(),p.getColor());
                if(pawnChange[0]!=-1){
                    String nPieces = "";
                    System.out.println("your Pawn can evolve to other pieces now!");
                    System.out.println("please enter the pieces you want");
                    System.out.println("(Rook/Knight/Bishop/Queen/)");

                    while((nPieces = fileReader.getNext())!=null){

                        if (nPieces.equals("Bishop")||nPieces.equals("Queen")||nPieces.equals("Knight")||nPieces.equals("Rook")) break;
                        else System.out.println("Please enter the correct piece name!(Rook/Knight/Bishop/Queen/)");
                    }
                    p.getBoard().changePiece(pawnChange[0],pawnChange[1],nPieces,p.getColor());
                    System.out.println("your pawn has been changed!");
                }
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
        System.out.println("---------------------------------------");
        return false;
    }
    private static int[] checkPawn(Board b, String color){
        int[] place = new int[2];
        place[0]=place[1]=-1;
        int dir = 0;
        if(color.equals("Black")) dir = 7;
        for(int i=0; i<=7;i++){
            if(b.pieces[dir][i] instanceof Pawn){
                place[0] = dir;
                place[1] = i;
            }
        }
        return place;
    }

}
