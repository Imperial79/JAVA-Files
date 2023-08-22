/*6. Write a program to find whether a matrix is orthogonal or not. Also find the 1-norm of the matrix. */

public class Prog6 {
    public void printMat(int arr[][]) {
        int row = arr.length;
        int col = arr[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    boolean isIdentity(int arr[][]) {
        int size = arr.length;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < i; j++) {
                if (i == j) {
                    if (arr[i][j] != 1) {
                        return false;
                    }
                } else if (arr[i][j] != 0) {
                    return false;
                }
            }
        }
        return true;
    }

    boolean isOrthogonal(int arr[][]) {

        if (arr.length != arr[0].length)
            return false;
        int n = arr.length;
        int trans[][] = new int[n][n];

        // transpose of arr[][]
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                trans[i][j] = arr[j][i];
            }
        }

        // product of ar[][] and its transpose
        int prod[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int sum = 0;
                for (int k = 0; k < n; k++) {
                    sum += arr[i][k] * arr[j][k];
                }
                prod[i][j] = sum;
            }
        }

        // checking if product is identity matrix ... if it is then the provided matrix
        // is Orthogonal
        return isIdentity(prod);

    }

    public static void main(String[] args) {

        Prog6 obj = new Prog6();
        int arr[][] = {
                { 1, 0, 0 },
                { 0, 1, 0 },
                { 0, 0, 1 }
        };
        System.out.println("Original Matrix ->");
        obj.printMat(arr);
        if (obj.isOrthogonal(arr))
            System.out.println("Matrix is Orthogonal");
        else
            System.out.println("matrix is not Orthogonal");
    }
}
