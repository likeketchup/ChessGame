//programmed by toma 2/28/2018
abstract public class piece
{
    abstract String color;
    abstract String name;
    abstract int X;//coordinate
    abstract int Y;//coordinate
    public piece(String name, String color){
        this.color = color;
        this.name = name;
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
