import java.util.ArrayList;
import java.util.Arrays;

public class BFS {

    boolean visited[];
    ArrayList<Integer> que = new ArrayList<>();
    int v;

    BFS(int n) {
        v = n;
        visited = new boolean[n];
        Arrays.fill(visited, false);
    }

    public void bfSearch(int curr, int arr[][]) {
        visited[curr] = true;
        que.add(curr);
        int vis;
        while (!que.isEmpty()) {
            vis = que.get(0);

            System.out.print(vis + " ");

            que.remove(0);

            for (int i = 0; i < v; i++) {
                if (arr[vis][i] == 1 && !visited[i]) {
                    que.add(i);
                    visited[i] = true;
                }
            }
        }
    }

    public static void main(String[] args) {

        int adj[][] = {
                { 0, 1, 1, 1, 0 },
                { 1, 0, 0, 0, 0 },
                { 1, 0, 0, 1, 1 },
                { 1, 0, 1, 0, 0 },
                { 0, 0, 1, 0, 0 },
        };

        BFS bfs = new BFS(adj.length);

        bfs.bfSearch(0, adj);
    }
}
