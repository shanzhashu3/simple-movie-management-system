import java.text.*;
/**
 * Write a description of class Movie here.
 *
 * @author (Shan Yin/12508949)
 * @version (a version number or a date)
 */
public class Movie
{
    // instance variables - replace the example below with your own
    private String title;
    
    private int year;
    
    private int price;
    
    private Genre genre;
    //constructor
    public Movie(String title, int year, Genre genre, int price){
        this.title = title;
        this.price = price;
        this.year = year;
        this.genre = genre;
    }
    
    public String getTitle(){
        return this.title;
    }
    
    public Genre getGenre(){
        return this.genre;
    }
    
    public int getPrice(){
        return this.price;
    }
    
    public int getYear(){
        return this.year;
    }
    
    public boolean hasTitle(String title){
        return title.equals(this.title);
    }
    
    public String toString(){
        return year + " " + title + " " + genre + " $" + price;
    }
    
}
