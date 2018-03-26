import java.util.Scanner;
public class Game
{

    public static void main(String[] args){

        try {  } catch(RuntimeException e){throw e; }

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


            System.out.println("White play");
            System.out.print("Move piece from ");String previous=scn.next();System.out.print(" to ");
            String later=scn.next();
            whitePlayer.movePiece(previous, later);
            System.out.println(b);

            System.out.println("Black play");
            System.out.print("Move piece from ");previous=scn.next();System.out.print(" to ");
            later=scn.next();
            blackPlayer.movePiece(previous, later);
            System.out.println(b);

            System.out.println("Do you want to exit?(y/n)");
            String exit=scn.next();
            if(exit.equals("y"))
            {
                break;
            }
        }


        System.out.println("game over");


    }
}
