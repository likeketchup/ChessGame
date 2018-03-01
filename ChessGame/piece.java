//programmed by toma 2/28/2018
abstract public class piece
{
    abstract String color;
    abstract String name;
    public piece(String name, String color){
        this.color = color;
        this.name = name;
    }
    abstract public move();
    
    public piece(){
        
    }
    public String toString(){
        if(this.name == null){
            return "O";
        }
        return this.color + this.name.substring(0,1);
    }
}
