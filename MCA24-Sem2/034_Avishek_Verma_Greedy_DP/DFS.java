import java.util.Arrays;

public class DFS {

    boolean visited[];

    DFS() {
        visited = new boolean[5];
        Arrays.fill(visited, false);
    }

    public void dfSearch(int current, int arr[][]) {

        System.out.println(current + " ");

        visited[current] = true;

        for (int i = 0; i < arr[current].length; i++) {
            if (arr[current][i] == 1 && !visited[i]) {
                dfSearch(i, arr);
            }
        }

    }

    public static void main(String[] args) {
        DFS dfs = new DFS();

        int adj[][] = {
                { 0, 1, 1, 1, 0 },
                { 1, 0, 0, 0, 0 },
                { 1, 0, 0, 1, 1 },
                { 1, 0, 1, 0, 0 },
                { 0, 0, 1, 0, 0 },
        };
        dfs.dfSearch(0, adj);
    }
}