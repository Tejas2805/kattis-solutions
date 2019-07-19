import java.util.*;
import java.io.*;

public class ants{

    public static void main( String[] args){
        ants o1 = new ants();
        o1.scanInput();
    }

    public static void scanInput(){
        try(Scanner sc = new Scanner(System.in)){
            int queries = sc.nextInt();
            for(int i = 0;i < queries; i++){

                int pole_length = sc.nextInt();
                int num_ants = sc.nextInt();
                int shortest = 0;
                int longest = 0;
                for(int j = 0; j < num_ants;j++){
                    int ant = sc.nextInt();
                    shortest = Math.max(shortest,(Math.min(ant,pole_length - ant )));
                    longest = Math.max(longest,(Math.max(ant, pole_length - ant)));

                }
                System.out.println(shortest + " " + longest);
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}