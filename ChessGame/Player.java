
public class Player
{
    private static int count = 0;
    private String name;
    private Board b;
    private String color;
    private Player(String name, String color, Board b){
        this.name = name;
        this.b = b;
        this.color=color;
    }
    String getName(){
        return name;
    }
    String getColor(){
        return color;
    }
    Board getBoard(){
        return b;
    }
    public boolean movePiece(String p1, String p2){
        int[] P1 = translator(p1);
        int[] P2 = translator(p2);
        String c=b.getPieceColor(P1[0],P1[1]);
        if(color.equals("White") && c.equals("W")){}
        else
        {
            if(color.equals("Black") && c.equals("B")){}
            else{throw new RuntimeException("this operation is illegal!");}
        }
        boolean judge = b.movePiece(P1[0],P1[1],P2[0],P2[1]);

        if(judge){
            return true;
        }
        return false;
    }
    public static Player factory(String name, String color, Board b){
        count++;
        if(count>2){
            throw new Error("You could only initialize 2 players.");
        }
        return new Player(name, color, b);
    }
    //please notice that the first section of the coordinate in our project is Y!
    public int[] translator(String p){
        int[] coordinate = new int[2];
        coordinate[0] = Math.abs(Integer.parseInt(p.substring(1,2))-1);//y
        coordinate[0] = Math.abs(coordinate[0]-7);
        coordinate[1] = ((int)p.charAt(0))-97;//x
        return coordinate;
    }

}
