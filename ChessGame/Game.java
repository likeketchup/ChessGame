import java.util.Scanner;
public class Game
{
    static Scanner scn=new Scanner(System.in);
    public static void main(String[] args){

        //try {  } catch(RuntimeException e){throw e; }
        String continuee="";
        System.out.println("This is a Chess Game develop by team SuperChess");
        System.out.println("Main Developer: Toma Chen, Eason Lu, Wendy Tan, Fiona Liu");
        System.out.println("Please enter 'Start' to start the chess game");
        while(scn.nextLine().equals("Start"))
        {
            Board b=Board.factory();
            System.out.println("A board has been create!");
            System.out.println("Please enter the name of White Player:");
            String whiteName = scn.nextLine();
            Player whitePlayer=Player.factory(whiteName,"White",b);
            System.out.println("Please enter the name of Black Player:");
            String blackName = scn.nextLine();
            Player blackPlayer=Player.factory(blackName,"Black",b);
            System.out.println("Two players have been create!");
            System.out.println(whiteName+", If you have prepared to start the game, Please enter 'P'");
            while(scn.nextLine().equals("P")){
                System.out.println(blackName+", If you have prepared to start the game, Please enter 'P'");
                while(scn.nextLine().equals("P")){
                    System.out.println("Game Start!");
                    System.out.println("Game Board Spreading!");
                    System.out.println("\n");
                    System.out.println(b);
                    System.out.println("---------------------------------------");
                    while(true){
                        if(playerAction(whitePlayer)) return ;
                        System.out.println(b);
                        if(playerAction(blackPlayer)) return ;
                        System.out.println(b);
                    }


                }
            }
        }

    }
    private static boolean playerAction(Player p){
        while(true){
            try{
                System.out.println("Is the time for "+p.getColor()+" Player "+p.getName()+" move the piece");
                System.out.println("Which piece do you want to move: ");
                String previous = scn.next();
                System.out.println("Where do you want this piece to go: ");
                String aim = scn.next();
                if(p.movePiece(previous, aim)){
                    System.out.println(p.getName()+" Win. Game End");
                    return true;
                }
            }
            catch(RuntimeException e){
                //System.out.println(e);
                e.printStackTrace();
                continue;
            }
            break;
        }
        System.out.println("-------------------------------");
        return false;
    }
    
}

