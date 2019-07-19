import java.util.*;
import java.io.*;

public class WheresMyInternet {
    private int number_of_cables;
    private int number_of_houses;
    private ArrayList<ArrayList<Integer>> adjList;

    public void run() {
        scanInput();
        ArrayList<Integer> answer = dfs(1);
        printAnswer(answer);
    }

    private void scanInput() {

        try (BufferedReader buffReader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] firstLine = buffReader.readLine().split(" ");

            number_of_houses = Integer.parseInt(firstLine[0]);
            number_of_cables = Integer.parseInt(firstLine[1]);

            adjList = new ArrayList<>();
            for (int i = 0; i <= number_of_houses; ++i) {
                adjList.add(new ArrayList<>());
            }

            for (int i = 0; i < number_of_cables; ++i) {
                String[] cable = buffReader.readLine().split(" ");
                int house1 = Integer.parseInt(cable[0]);
                int house2 = Integer.parseInt(cable[1]);

                adjList.get(house1).add(house2);
                adjList.get(house2).add(house1);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private ArrayList<Integer> dfs(int source) {

        boolean[] isVisited = new boolean[number_of_houses + 1];


        recursiveDfs(source, isVisited);


        ArrayList<Integer> output = new ArrayList<>();
        for (int i = 1; i <= number_of_houses; ++i) {
            if (!isVisited[i]) {
                output.add(i);
            }
        }

        return output;
    }

    private void recursiveDfs(int current, boolean[] isVisited) {
        isVisited[current] = true;


        for (int neighbour : adjList.get(current)) {

            if (!isVisited[neighbour]) {
                recursiveDfs(neighbour, isVisited);
            }
        }
    }

    public static void main(String[] args) {
        WheresMyInternet internet = new WheresMyInternet();
        internet.run();
    }

    private void printAnswer(ArrayList<Integer> answer) {

        try (BufferedWriter buffWriter = new BufferedWriter(new OutputStreamWriter(System.out))) {
            if (answer.size() == 0) {
                buffWriter.write("Connected\n");
            } else {
                for (int house : answer) {
                    buffWriter.write(house + "\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
