import java.util.*;
/** 
 * Movie Renting System
 *
 * @author (Shan Yin 12508949)
 * @version (25/04/2019)
 */
public class Kiosk
{
    // insert main method
    public static void main(String[] args){
        //Kiosk kiosk = new Kiosk();
        //kiosk.use();
        new Kiosk().use();

    }
    //field
    private Catalogue catalogue;
    private List<Customer> customers;
    //contrustor
    public Kiosk(){
        catalogue = new Catalogue(null);
        customers = new LinkedList<Customer>();
        customers.add(new Customer(101,"Jaime",10));
        customers.add(new Customer(102,"Luke",10));
        customers.add(new Customer(103,"William",1));
    } 

    //kiosk movie menu
    private char readChoice(){
        System.out.println("Welcome to the Movie Kiosk! Please make a selection from the menu:");
        System.out.println("1. Explore the catalogue.");
        System.out.println("2. View your customer record.");
        System.out.println("3. Show you favourite movies.");
        System.out.println("4. Top up account.");
        System.out.println("5. Enter Admin Mode.");
        System.out.println("X. Exit the system.");
        System.out.print("Enter a choice: ");

        return In.nextChar();

    }

    public void use(){
        char choice;
        while((choice=readChoice())!='X'){
            switch(choice){
                case '1': catalogue1();break;
                case '2': viewRecord2();break;
                case '3': favouriteMovie();break;
                case '4': topUpAccount4();break;
                case '5': adminMode5();break;
                default: kioskBadInput();break;
            }
        }
    }

    public void kioskBadInput(){
        System.out.println("Please enter a number between 1 and 5, or press X to exit.");
    }
    //Kiosk menu function

    //1. Explore the catalogue.
    public void catalogueBadInput(){
        System.out.println("Please enter a number between 1 and 7 or press R to return to the previous menu.");

    }

    public char cataReadChoice(){
        System.out.println("Welcome to the Catalogue! Please make a selection from the menu:");
        System.out.println("1. Display all movies.");
        System.out.println("2. Display all available movies.");
        System.out.println("3. Display all genres.");
        System.out.println("4. Display movies in a genre.");
        System.out.println("5. Display all movies by year.");
        System.out.println("6. Rent a movie.");
        System.out.println("7. Return a movie.");
        System.out.println("R. Return to previous menu.");
        System.out.print("Enter a choice: ");
        return In.nextChar();
    }

    private void catalogue1(){
        char choice;
        while((choice = cataReadChoice()) != 'R'){
            switch(choice){
                case '1': allMovies();break;
                case '2': availableMovies();break;
                case '3': allGenres();break;
                case '4': moviesInGenre();break;
                case '5': moviesByYear();break;
                case '6': rentMovies();break;
                case '7': returnMovie();break;
                default: catalogueBadInput();break;
            }

        }
    }
    //1.1 Display all movies.
    private void allMovies(){
    }

    //1.2 Display all available movies.
    private void availableMovies(){
        catalogue.availableMovies();
    }

    //1.3 Display all genres.
    private void allGenres(){
        System.out.println(" ");
        System.out.println("The Kiosk has movies in the following genres: ");
        catalogue.showAllGenres();
        System.out.println(" ");
    }

    //1.4 Display movies in a genre.
    private void moviesInGenre(){
        catalogue.showMoviesInGenre();
    }

    //1.5 Display all movies by year.
    private void moviesByYear(){
        catalogue.showMoviesByYear();
    }

    //1.6 Rent a movie.
    private void rentMovies(){
        System.out.println("");
        int ID = readValidID();
        Customer customer= hasCustomer(ID);
        if(customer != null){
            String title = readRentMovieTitle();
            Movie movie = catalogue.movie(title);
            if(movie != null){
                //movie rent
                boolean result = catalogue.rentMovie(title);
                if(result == true){
                    if(customer.getBalance() > movie.getPrice()){
                     customer.rentMovie(movie);
                     System.out.println( "Movie rented.");
                     customer.useBalance();
                     System.out.println(" ");
                    }else{
                       System.out.println("You don't have sufficient funds to rent this movie.");
                       catalogue.returnMovie(title);
                       System.out.println(" ");
                    }
                }
            }else{
                System.out.println("That movie is not available or doesn't exist.");
                System.out.println(" ");
            }
        }
        else{
            System.out.print("No such customer.");
            System.out.println("");
        }
    }

    public int readValidID(){
        System.out.print("Enter a valid customer ID: ");
        return In.nextInt();
    }

    public String readRentMovieTitle(){
        System.out.print("Enter the title of the movie you wish to rent: ");
        return In.nextLine();
    }
    //Customer customer= hasCustomer(ID);
    // 1.7 Return a movie.
    public Customer hasCustomer(int ID){
        for(Customer customer: customers)
            if( customer.hasID(ID))
                return customer;
        return null;
    }

    private void returnMovie(){
        System.out.println(" ");
        int ID = readValidID();
        Customer customer = hasCustomer(ID);

        if(customer !=null){
            System.out.println(customer.getName() +" has the following movies: ");
            System.out.println("Movies currently rented by " +customer.getName() + ": ");
            customer.getCurrentlyRented();
            String title = readReturnMovieTitle();
            Movie movie = catalogue.movie1(title);
            if(movie != null){
                boolean result = catalogue.returnMovie(title);
                
                if(result == true){
                    customer.returnMovie(movie);
                    System.out.println( title+" has been returned. ");
                    System.out.println("");
                }
            }
        }else{
            System.out.print("No such customer.");
            System.out.println("");
        }

    }

    public String readReturnMovieTitle(){
        System.out.print("Enter the title of the movie you wish to return: ");
        return In.nextLine();
    }
    // end 1 catalogue menu

    //2. View your customer record.
    private void viewRecord2(){
        System.out.println("");
        int ID = readID();
        Customer customer = hasCustomer(ID);
        if(customer != null){  
            System.out.println(customer.toString1());
            System.out.println("Movies currently rented by "+customer.getName()+": ");
            customer.getCurrentlyRented();
            System.out.println(customer.getName()+"'s renting history: ");
            customer.getRentingHistory();
            System.out.println("");
        }
        else{
            System.out.println("That customer does not exist.");
            System.out.println(" ");
        }

    }

    //3. Show you favourite movies.
    private void favouriteMovie(){
        System.out.println(" ");
        int ID=readID();
        Customer customer = hasCustomer(ID);
        if(customer!= null){
           System.out.println(customer.getName() +"'s favourite movies are:");
           customer.favouriteMovies();
           System.out.println(" ");
        }else{
           System.out.println("That customer does not exist.");
           System.out.println(" ");
        }
        
        
    }
    //4. Top up account.
    private void topUpAccount4(){
        System.out.println(" ");
        int ID = readID();
        Customer customer = hasCustomer(ID);
        if(customer != null){
          int amount = readAmount();
          System.out.println(" ");
          System.out.println("Transaction complete.");
          int balance = customer.getBalance();
          System.out.println(customer.getName()+"'s balance was: $" + balance);
          customer.setBalance(balance = balance + amount);
          System.out.println(customer.getName()+"'s current balance is: $" + balance);
          System.out.println(" ");
        }
        else{
          System.out.println("That customer does not exist.");
          System.out.println(" ");
        }
        
    }
    
    public int readAmount(){
        System.out.print("Enter the top-up amount:");
        return In.nextInt();
    }

    //5. Enter Admin Mode.
    private char readChoice_admi(){
        System.out.println("Welcome to the administration menu: ");
        System.out.println("1. List all customers.");
        System.out.println("2. Add a customer.");
        System.out.println("3. Remove a customer.");
        System.out.println("4. List all movies.");
        System.out.println("5. Add a movie to the catalogue.");
        System.out.println("6. Remove a movie from the catalogue.");
        System.out.println("R. Return to the previous menu.");
        System.out.print("Enter a choice: ");
        return In.nextChar();
    }

    private void adminMode5(){
        char choice1;
        while((choice1=readChoice_admi())!='R'){
            switch(choice1){
                case '1': listCustomers_1();break;
                case '2': addCustomer_2();break;
                case '3': removeCustomer_3();break;
                case '4': listMovies_4();break;
                case '5': addMovie_5();break;
                case '6': removeMovie_6();break;
                default: adminBadInput();break;
            }
        }
    }

    public void adminBadInput(){
        System.out.println("Please enter a number between 1 and 6 or press R to return to the previous menu.");
    }
    // end Kiosk menu function

    //admin menu
    //5.1.List all customers.
    private void listCustomers_1(){
        System.out.println(" ");
        System.out.println("The Kiosk has the following customers: ");
        for (Customer customer: customers)
            System.out.println(customer);
        System.out.println(" ");
    }

    //5.2 Add a customer.
    private void addCustomer_2(){
        System.out.println("");
        System.out.println("Adding a new customer.");
        // int ID = readNewID();
        // String name = readName();
        // int balance = readBalance();
        customers.add(new Customer(readNewID(),readName(),readBalance()));
        System.out.println("Customer added.");
        System.out.println("");
    }

    public int readNewID(){
        System.out.print("Enter a new ID: ");
        return In.nextInt();
    }

    public int readID(){
        System.out.print("Enter a customer ID: ");
        return In.nextInt();
    }

    public String readName(){
        System.out.print("Enter the customer's name: ");
        return In.nextLine();
    }

    public int readBalance(){
        System.out.print("Enter the customer's initial balance: ");
        return In.nextInt();
    }

    //5.3 Remove a customer.
    private void removeCustomer_3(){
        System.out.println("");
        System.out.println("Removing a customer.");
        int ID = readID();
        Customer customer = hasCustomer(ID);
        if(customer!=null){
            customers.remove(customer);
            System.out.println("Customer removed.");
            System.out.println("");
        }else{
            System.out.println("That customer does not exist.");
            System.out.println("");
        }
    }

    //5.4  List all movies.
    private void listMovies_4(){
        System.out.println(" ");
        System.out.println("The Kiosk has the following movies: ");
        catalogue.listMovie();
        System.out.println(" ");
    }

    //5.5 Add a movie to the catalogue.
    private void addMovie_5(){
        catalogue.addMovie();
    }

    //5.6  Remove a movie from the catalogue.
    private void removeMovie_6(){
        catalogue.removeMovie();
    }
    //end admin menu 

    private void kioskHelp(){
        System.out.println("Menu options");
        System.out.println("1. Explore the catalogue.");
        System.out.println("2. View your customer record.");
        System.out.println("3. Show you favourite movies.");
        System.out.println("4. Top up account.");
        System.out.println("5. Enter Admin Mode.");
        System.out.println("x. Exit the system.");
    }

    private void adminHelp(){
        System.out.println("Menu options ");
        System.out.println("1. List all customers.");
        System.out.println("2. Add a customer.");
        System.out.println("3. Remove a customer.");
        System.out.println("4. List all movies.");
        System.out.println("5. Add a movie to the catalogue.");
        System.out.println("6. Remove a movie from the catalogue.");
        System.out.println("R. Return to the previous menu.");
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
