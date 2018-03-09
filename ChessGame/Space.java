
public class Space extends Piece
{
    Space(){
        this.color="s";
    }
    public boolean move(int x, int y)
    {
    	return  true;
    }
    public String toString(){
        return "  ";
    }
}
