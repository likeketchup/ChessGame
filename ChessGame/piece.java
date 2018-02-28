//programmed by toma 2/28/2018


public class piece
{
    private String color = new String();
    private String name = new String();
    public piece(String name, String color){
        this.color = color;
        this.name = name;
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
