import java.util.Scanner;
public class Game
{

    public static void main(){

        //try {  } catch(RuntimeException e){throw e; }

        Scanner scn=new Scanner(System.in);
        String continuee="";
        while(!continuee.equals("yy"))
        {
            System.out.println("Do you want to start a game? (y/n)"+"["+"whitePlayer"+"]");
            continuee=scn.nextLine();
            System.out.println("Do you want to start a game? (y/n)"+"["+"blackPlayer"+"]");
            continuee+=scn.nextLine();
        }
        
        Board b=Board.factory();
        
        System.out.println("Enter the name of User 1（white）:");
        String firstName=scn.nextLine();
        Player whitePlayer=Player.factory(firstName,"white",b);
        System.out.println("Enter the name of User 2(black):");
        String secondName=scn.nextLine();
        Player blackPlayer=Player.factory(secondName,"black",b);
        System.out.println("\n");
    
        System.out.println(b);

        while(continuee.equals("yy"))
        {
            
            String previous = "";
            String later = "";
            while(true){
                try{
                    System.out.println("White play");
                    System.out.print("Move piece from:");
                    previous=scn.next();
                    System.out.print(" to ");
                    later=scn.next();
                    whitePlayer.movePiece(previous, later);
                }
                catch(RuntimeException e){
                    System.out.println(e);
                    continue;
                }
                break;
            }
            System.out.println(b);
            
            while(true){
                try{
                    System.out.println("Black play");
                    System.out.print("Move piece from:");
                    previous=scn.next();
                    System.out.print(" to ");
                    later=scn.next();
                    blackPlayer.movePiece(previous, later);
                }
                catch(RuntimeException e){
                    System.out.println(e);
                    continue;
                }
                break;
            }
            System.out.println(b);
        }
        
        System.out.println("game over");

    }
    
}
