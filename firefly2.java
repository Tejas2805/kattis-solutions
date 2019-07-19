import java.io.*;
import java.util.*;

public class firefly2 {

    public static void main(String args[]){
        firefly2 o2 = new firefly2();
        o2.scanInput();
    }

    public static void update(int ind, int v){
        for (int x = ind; x < 500005; x += (x & -x)) {
            obstacles[x] += v;
        }
    }
   private static int obstacles[] = new int[500005];

    public static int query(int ind) {
        int ret = 0;

        for (int x = ind; x>0;  x -= (x & -x)) {
            ret += obstacles[x];
        }

        return ret;
    }

    public static void scanInput(){
        try(BufferedReader br = new BufferedReader((new InputStreamReader(System.in)))){
            String[] sizes = (br.readLine().split(" "));

            int columns = Integer.parseInt(sizes[0]);
            int rows = Integer.parseInt(sizes[1]);


            int obstacles[] = new int[rows];
            for(int i = 0; i < columns; i++) {
                int x = Integer.parseInt(br.readLine().trim());
                if (i % 2!= 0) {

                    update(1, 1);
                    update(x + 1, -1);
                } else {
                    update(rows - x + 1, 1);
                    update(rows + 1, -1);
                }
            }


            int min_val = 100000000;
            int ways = 0;

            for (int y = 1; y <= rows; ++y) {
                int q = query(y);
                // printf("%d %lld\n", y, q);
                if (q < min_val) {
                    min_val = q;
                    ways = 0;
                }

                if (q == min_val) {
                    ++ways;
                }
            }

            System.out.println(min_val + " " + ways);

        }

        catch(Exception e){
            System.out.println(e);
        }
    }
}