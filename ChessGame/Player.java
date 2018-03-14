
public class Player
{
    static int count = 0;
    private String name;
    private Board b;
    private Player(String name){
        this.name = name;
    }
    public void movePiece(int x1, int y1, int x2, int y2){
        this.b.movePiece(x1,y1,x2,y2);
    }
    public void setBoard(Board b){
        this.b=b;
    }
    public Player factory(String name){
        count++;
        if(count>2){
            throw new Error("You could only initialize 2 players.");
        }
        return new Player(name);
    }
}
