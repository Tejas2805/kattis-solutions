import java.util.*;
import java.io.*;

public class evenUpSolitaire {

    public static void main(String args[]){
        evenUpSolitaire o1 = new evenUpSolitaire();
        o1.scanInput();
    }

    public static void scanInput(){
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            int total = Integer.parseInt(br.readLine().trim());
            String[] integers = br.readLine().split(" ");
            LinkedList<Integer> list = new LinkedList<>();
            for(int i = 0; i<total;i++) {
                list.add(Integer.parseInt(integers[i]));
            }

            int count = 1;
            while(count > 0) {
                count = 0;
                ListIterator<Integer> it = list.listIterator();
                int prev = -1;
                while (it.hasNext()) {
                    int curr = it.next();
                    if (prev == -1) {
                        prev = curr;
                        if (it.hasNext())
                            curr = it.next();
                        else
                            break;
                    }
                    if ((prev + curr) % 2 == 0) {
                        count++;
                        it.remove();
                        it.previous();
                        it.remove();
                        prev = -1;
                    } else
                        prev = curr;
                }
            }

        System.out.println(list.size());
        }
        catch(Exception e){
            System.out.println(e);
        }

    }
}