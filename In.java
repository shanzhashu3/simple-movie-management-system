import java.util.*;
/**
 * Write a description of class In here.
 *
 * @author (Shan Yin/12508949)
 * @version (a version number or a date)
 */
public class In
{
    private static final Scanner scanner = new Scanner(System.in);
    
    private In(){}
    
    public static String nextLine(){
        return scanner.nextLine();
    }
    
    public static int nextInt(){
        int value = scanner.nextInt();
        scanner.nextLine();
        return value;
    }
    
    public static double nextDouble(){
        double value = scanner.nextDouble();
        scanner.nextLine();
        return value;
    }
    
    public static char nextChar(){
        return scanner.nextLine().charAt(0);
    }
    
}
