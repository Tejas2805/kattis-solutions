import java.util.*;
import java.io.*;

public class cd {

    public static void main(String[] args) {
        cd cd1 = new cd();
        cd1.findCds2();
    }

    public static void findCds2()  {
        try  (BufferedReader buffReader = new BufferedReader(new InputStreamReader(System.in))) {
            Set<Integer> x = new HashSet<>();
           while(true){
               int both = 0;
            String[] codes = buffReader.readLine().split(" ");

            int num_Jack = Integer.parseInt(codes[0]);
            int num_Jill = Integer.parseInt(codes[1]);

               if ((num_Jack == 0) && (num_Jill == 0)) {
                   break;
               }

            if((num_Jack == 0)||(num_Jill == 0)) {

                System.out.println(both);
            }



            for (int c = 0; c < num_Jack; c++) {
                int n = Integer.parseInt(buffReader.readLine().trim());
                if (x.contains(n)) {
                    continue;
                } else
                x.add(n);
            }
            for (int c = 0; c < num_Jill; c++) {
                int n = Integer.parseInt(buffReader.readLine().trim());
                if (x.contains(n)) {
                    x.remove(n);
                    both++;
                }
            }
               System.out.println(both);

            }
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}