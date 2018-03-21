import java.util.Scanner;
public class Game
{

    public static void main(String[] args){

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
        Player whitePlayer=Player.factory(firstName,b);
        System.out.println("Enter the name of User 2(black):");
        String secondName=scn.nextLine();
        Player blackPlayer=Player.factory(secondName,b);
        System.out.println("\n");

        while(continuee.equals("yy"))
        {
            System.out.println(b);

            System.out.println("White play");
            System.out.print("Move piece from (");String previousOne=scn.nextLine();System.out.print(",");String previousTwo=scn.nextLine();System.out.print(") to (");
            String laterOne=scn.nextLine();System.out.print(",");String laterTwo=scn.nextLine();System.out.println(")");
            whitePlayer.movePiece(previousOne+previousTwo, laterOne+laterTwo);

            System.out.println("Black play");
            System.out.print("Move piece from (");previousOne=scn.nextLine();System.out.print(",");previousTwo=scn.nextLine();System.out.print(") to (");
            laterOne=scn.nextLine();System.out.print(",");laterTwo=scn.nextLine();System.out.println(")");
            blackPlayer.movePiece(previousOne+previousTwo, laterOne+laterTwo);

        }


        System.out.println("game over");


    }
}
