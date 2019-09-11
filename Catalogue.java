import java.util.*;
/**
 * Write a description of class Catalogue here.
 *
 * @author (Shan Yin/12508949)
 * @version (a version number or a date)
 */
public class Catalogue
{

    private Kiosk kiosk;
    private List<Movie> moviesAvailable;
    private List<Movie> moviesRented;
    private List<Genre> genres;
    public Catalogue(Kiosk kiosk){
        this.kiosk = kiosk;
        //LinkedList<Movie> movies = new LinkedList<Movie>();
        moviesAvailable = new LinkedList<Movie>();
        moviesRented = new LinkedList<Movie>();
        genres = new LinkedList<Genre>();
        moviesAvailable.add(new Movie("Matrix",1999,new Genre("SciFi"),3));
        moviesAvailable.add(new Movie("Jurassic Park",1993,new Genre("SciFi"),4));
        moviesAvailable.add(new Movie("Terminator 2",1991,new Genre("SciFi"),3));
        moviesAvailable.add(new Movie("Titanic",1997,new Genre("Drama"),4));
        moviesAvailable.add(new Movie("The Silence of the Lambs",1991,new Genre("Crime"),3));
        genres.add(new Genre("SciFi"));
        genres.add(new Genre("Drama"));
        genres.add(new Genre("Crime"));
    }

    //5.4  List all movies.
    public void listMovie(){
        for(Movie movie: moviesAvailable)
            System.out.println(movie.toString());
    }

    //5.5 Add a movie to the catalogue.
    public void addMovie(){
        System.out.println(" ");
        System.out.println("Adding a new movie.");
        String title = readTitle();
        int year = readYear();
        String genre = readGenre();
        int price = readPrice();
        Movie movie = movie(title);
        if(movie == null){
            moviesAvailable.add(new Movie(title,year,new Genre(genre),price));
            System.out.println("Added " + title +" to catalogue.");
            if(hasGenre(genre) == null){
                genres.add(new Genre(genre));
            }
        }else{
            System.out.print("The movie is already in the catalogue.");
        }
        System.out.println(" ");
    }

    public Genre hasGenre(String name){
        for(Genre genre1: genres)
            if( genre1.hasName(name))
                return genre1;
        return null;
    }

    //5.6  Remove a movie from the catalogue.
    public Movie movie(String title){
        for(Movie movie: moviesAvailable)
            if( movie.hasTitle(title))
                return movie;
        return null;
    }

    public Movie movie1(String title){
        for(Movie movie: moviesRented)
            if( movie.hasTitle(title))
                return movie;
        return null;
    }

    public void removeMovie(){
        System.out.println(" ");
        System.out.println("Removing a movie.");
        String title = readTitle();
        readYear();
        Movie movie = movie(title);
        if(movie!= null){
            moviesAvailable.remove(movie);
            System.out.println(movie.toString() + " removed from catalogue.");
            System.out.println(" ");
        }else{
            System.out.println("No such movie found.");
            System.out.println(" ");
        }
    }

    public String readTitle(){
        System.out.print("Enter the title of the movie: ");
        return In.nextLine();
    }

    public int readYear(){
        System.out.print("Enter the year: ");
        return In.nextInt();
    }

    public String readGenre(){
        System.out.print("Enter the genre: ");
        return In.nextLine();
    }

    public int readPrice(){
        System.out.print("Enter price: ");
        return In.nextInt();
    }
    
    //1.2 Display all available movies.
    public void availableMovies(){
        System.out.println("");
        System.out.println("The following movies are available: ");
        for(Movie movie: moviesAvailable){
           System.out.println(movie.toString());
        }
        System.out.println(" ");
    }
    //1.3 Display all genres.
    public void showAllGenres(){
       for(int i = 0; i<genres.size();i++){
            System.out.println(genres.get(i));
       }
        
    }
    
    //1.4 Display movies in a genre.
    public void showMoviesInGenre(){
        System.out.println(" ");
        String genre = readOneGenre();
        System.out.println("The kiosk has the following movies in that genre: ");
        for(Movie movie: moviesAvailable){
         if(movie.getGenre().getName().equals(genre)){
           System.out.println(movie.toString());
         }
        }
        System.out.println(" ");
    }
    
    public String readOneGenre(){
        System.out.print("Enter a genre: ");
        return In.nextLine();
    }
    
    //1.5 Display all movies by year.
    public void showMoviesByYear(){
        System.out.println(" ");
        int year = readYear();
        System.out.println("The Kiosk has the following movies by that year:");
        for(Movie movie: moviesAvailable){
           if(movie.getYear() == year){
             System.out.println(movie.toString());
           }
        }
        System.out.println(" ");
    }
    
    //1.6 Rent a movie.
    public int movieAvaliable(String title){
        for(int i =0; i<moviesAvailable.size(); i++){
            if(moviesAvailable.get(i).getTitle().equals(title)){
                return i;
            }
        }
        return -1;
    }

    public boolean rentMovie(String title){
        int indicator = movieAvaliable(title);
        if(indicator!=-1){
            Movie movie = moviesAvailable.get(indicator);
            moviesAvailable.remove(movie);
            moviesRented.add(movie);
            return true;
        }
        return false;
    }

    // 1.7 Return a movie.
    public int moviesRented(String title){
        for(int i =0; i<moviesRented.size(); i++){
            if(moviesRented.get(i).getTitle().equals(title)){
                return i;
            }
        }
        return -1;
    }

    public boolean returnMovie(String title){
        int indicator = moviesRented(title);
        if(indicator!=-1){
            Movie movie = moviesRented.get(indicator);
            moviesRented.remove(movie);
            moviesAvailable.add(movie);
            return true;
        }
        return false;
    }

    public String rentMoiveTitle(String title){
        for(Movie movie: moviesRented){}
        return title;
    }

    private void catelogueHelp(){
        System.out.println("Menu options");
        System.out.println("1. Display all movies.");
        System.out.println("2. Display all available movies.");
        System.out.println("3. Display all genres.");
        System.out.println("4. Display movies in a genre.");
        System.out.println("5. Display all movies by year.");
        System.out.println("6. Rent a movie.");
        System.out.println("7. Return a movie.");
        System.out.println("R. Return to previous menu.");
    }
}
