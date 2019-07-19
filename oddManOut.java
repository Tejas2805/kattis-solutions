import java.util.*;
import java.io.*;

public class oddManOut {

    public static void main(String[] args) {
        oddManOut o1 = new oddManOut();
        o1.scanInput();
    }

    public static void scanInput()  {
        try  (BufferedReader buffReader = new BufferedReader(new InputStreamReader(System.in))) {
                        int totalCases = Integer.parseInt(buffReader.readLine().trim());
        for (int c = 0; c < totalCases; c++) {
            int n =  Integer.parseInt(buffReader.readLine().trim());
            Set<Integer> x = new HashSet<>();
            String[] codes = buffReader.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                 int code = Integer.parseInt(codes[i]);
                if (x.contains(code)) x.remove(code);
                else {
                    x.add(code);
                }
            }
            System.out.println("Case #" + (c + 1) + ": " + (x.toArray())[0]);
        }
    }
    catch(Exception e ){
            System.out.println(e);
    }
   }
}
    
    
    
    
    
    
    
    
    

    
    
    
    
    



