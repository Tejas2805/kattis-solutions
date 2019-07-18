import java.io.*;
import java.util.*;

public class uniqueSnowflakes {

    public static void main(String args[]){
        uniqueSnowflakes o1 = new uniqueSnowflakes();
        o1.scanInput();
    }

    public static int longestSubarray(int[] arr) {
        int i = 0, j = 1, max = 0, currLength = 1;
        HashSet<Integer> set = new HashSet<Integer>();
        set.add(arr[0]);

        while (i < arr.length - 1 && j < arr.length) {
            if (!set.contains(arr[j])) {
                currLength++;
                set.add(arr[j++]);
            }
            else {
                max = Math.max(max, currLength);
                set.remove(arr[i++]);
                currLength--;
            }
        }

        return Math.max(currLength, max);
    }

    public static void scanInput(){
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){

            int total_cases = Integer.parseInt(br.readLine().trim());
            for(int i = 0; i < total_cases; i++){
                int number_of_snowflakes = Integer.parseInt(br.readLine().trim());
                int arr[] = new int[number_of_snowflakes];
                for(int j = 0; j < number_of_snowflakes;j++) {
                    int size_of_snowflake = Integer.parseInt(br.readLine().trim());
                    arr[j] = size_of_snowflake;
                }
                System.out.println(longestSubarray(arr));
            }

        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
