
/**
 * Write a description of class Genre here.
 *
 * @author (Shan Yin/12508949)
 * @version (a version number or a date)
 */
public class Genre
{
    // instance variables - replace the example below with your own
    private String name;
    
    public Genre(String name){
        this.name = name;
    }
    
    public boolean hasName(String name){
       return this.name.equals(name);
    }
    
    public String getName(){
        return this.name;
    }
    
    
    public String toString(){
        return name;
    }
}
