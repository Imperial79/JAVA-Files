/*4. Write class SparseMatrix to give a compressed storage representation of a sparse matrix and
also find the transpose of the sparse matrix (from the compressed representation). */

public class Prog4 {
    public static void main(String[] args) {
        int sparse[][] = {
                { 0, 0, 6, 0, 9 },
                { 0, 0, 4, 6, 0 },
                { 0, 0, 0, 0, 0 },
                { 0, 1, 2, 0, 0 }
        };
        System.out.println("Sparse matrix");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(sparse[i][j] + " ");
            }
            System.out.println();
        }

        int size = 0;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                if (sparse[i][j] != 0) {
                    size++;
                }
            }
        }

        int mat[][] = new int[3][size];
        int k = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                if (sparse[i][j] != 0) {
                    mat[0][k] = i;
                    mat[1][k] = j;
                    mat[2][k] = sparse[i][j];
                    k++;
                }
            }
        }

        System.out.println("Final matrix");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("Transposed matrix");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(mat[j][i] + " ");
            }
            System.out.println();
        }
    }
}
