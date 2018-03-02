//programmed by toma 2/28/2018
abstract public class piece
{
    String color;
    String name;
    int X;//coordinate
    int Y;//coordinate
    public piece(String color,int X, int Y){
        this.color = color;
        this.X = X;
        this.Y = Y;
    }
    abstract public void move(int x, int y); //change the coordinate
    public String getXY(){//get the coordinate
    	return "("+X+","+Y+")";
    }
    public piece(){
        
    }
    public String toString(){
        if(this.name == null){
            return "O";
        }
        return this.color + this.name.substring(0,1);
    }
}
