
public class Player
{
    //the first
    static int count = 0;
    private String name;
    private Board b;
    private Player(String name,Board b){
        this.name = name;
        this.b = b;
    }
    public void movePiece(String p1, String p2){
        int[] P1 = translator(p1);
        int[] P2 = translator(p2);

        b.movePiece(P1[0],P1[1],P2[0],P2[1]);
    }
    public static Player factory(String name,Board b){
        count++;
        if(count>2){
            throw new Error("You could only initialize 2 players.");
        }
        return new Player(name,b);
    }
    //please notice that the first section of the coordinate in our project is Y!
    public int[] translator(String p){
        int[] coordinate = new int[2];
        coordinate[0] = Math.abs(Integer.parseInt(p.substring(1,2))-1);//x
        coordinate[1] = ((int)p.charAt(0))-65;//y
        return coordinate;
    }

}
