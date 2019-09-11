import java.util.*;
/**
 * Write a description of class Customer here.
 *
 * @author (Shan Yin/12508949)
 * @version (a version number or a date)
 */
public class Customer
{
    // instance variables - replace the example below with your own
    private int ID;

    private String name;

    private int balance;

    private List<Movie> currentlyRented;//linkedlist

    private List<Movie> rentingHistory;

    public Customer(int ID, String name, int balance){
        this.ID = ID;
        this.name = name;
        this.balance = balance;

        currentlyRented = new LinkedList<Movie>();
        rentingHistory = new LinkedList<Movie>();
    }

    public String getName() {
        return this.name;
    }

    public boolean hasID(int ID){
        return this.ID==(ID);
    }

    public void useBalance(){
        for(Movie movie: currentlyRented){
            int price = movie.getPrice();
            balance -= price;
        }

    }

    public int getBalance() {
        return this.balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int readAmount(){
        System.out.print("Enter the top-up amount:");
        return In.nextInt();
    }

    public boolean hasCustomer(String name){
        return this.name.equals(name);
    }

    public void rentMovie(Movie movie){
        currentlyRented.add(movie);
        rentingHistory.add(movie);
    }

    public void returnMovie(Movie movie){
        currentlyRented.remove(movie);
    }

    public void getCurrentlyRented(){
        for(Movie movie: currentlyRented ){
            System.out.println(movie);
        }

    }

    public void getRentingHistory(){
        for(Movie movie: rentingHistory ){
            System.out.println(movie);
        }
    }

    //3. Show you favourite movies.
    public void favouriteMovies(){
        LinkedHashMap<String,Integer> map = new LinkedHashMap<String, Integer>();
        for(Movie movie: rentingHistory){
            if(map.containsKey(movie.getTitle())){
                int count = map.get(movie.getTitle());
                map.put(movie.getTitle(),++count);
            }else{
                map.put(movie.getTitle(),1);
            }
        }
        LinkedHashMap<String,Integer> map1 = new LinkedHashMap<String, Integer>();
         for(String key:map.keySet()){
         if(map1.size()<3){
            map1.put(key,map.get(key));
          }else{
            int c =100; String k=null;
            for(String key1 : map1.keySet()){
                 if (map1.get(key1) <= c){
                   c= map1.get(key1);
                   k = key1;
                }
            }
            if(map.get(key) > map1.get(k)){
                    map1.remove(k);
                    map1.put(key, map.get(key));
            }
         }
        }
        
        LinkedHashMap<String,Integer> map2 = new LinkedHashMap<String, Integer>();
        int c = -1; 
        String k= null;
        int size = map1.size();
        for(int i=0; i < size; i++){
           for(String key1: map1.keySet()){
               if(map1.get(key1) > c){
                 c=map1.get(key1);
                 k=key1;
               }
           }
           map2.put(k,map1.get(k));
           map1.remove(k);
           c = -1; k =null;
        }
        
        for(String key2: map2.keySet()){
              //System.out.println(key1);
              for(Movie movie:rentingHistory){
                if(key2.equals(movie.getTitle())){
                   System.out.println(movie);
                   break;
                }
               }
        }
    }

    public Movie hasMovie(String title){
        for(Movie movie:rentingHistory)
            if(movie.hasTitle(title))
                return movie;
        return null;
    }

    public String toString(){
        return ID+ " "+ '\t'+name+'\t'+"$ " + balance;
    }

    public String toString1(){
        return "ID: " + ID +'\n' + "Name: " + name + '\n' + "Balance: $" + balance;
    }

}
