
/*5. Write a Class CheckTriangular within that implement methods to check whether a matrix is
i) Lower triangular ii) Upper triangular iii) Diagonal iv) Identity v) Tridiagonal. */

class CheckTriangle {
    void printMat(int arr[][]) {
        int row = arr.length;
        int col = arr[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    boolean isLowerTriangular(int arr[][]) {
        int size = arr.length;
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                if (arr[i][j] != 0) {
                    return false;
                }
            }
        }
        return true;
    }

    boolean isUpperTriangular(int arr[][]) {
        int size = arr.length;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i][j] != 0) {
                    return false;
                }
            }
        }
        return true;
    }

    boolean isDiagonal(int arr[][]) {
        int size = arr.length;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < i; j++) {
                if (i == j) {
                    if (arr[i][j] == 0) {
                        return false;
                    }
                } else if (arr[i][j] != 0) {
                    return false;
                }
            }
        }
        return true;
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

    boolean isTridiagonal(int arr[][]) {
        int size = arr.length;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < i; j++) {
                if (i == j || i - 1 == j || i + 1 == j) {
                    if (arr[i][j] == 0) {
                        return false;
                    }
                } else if (arr[i][j] != 0) {
                    return false;
                }
            }
        }
        return true;
    }
}

public class Prog5 {
    public static void main(String[] args) {
        CheckTriangle check = new CheckTriangle();
        // LOWER TRIANGULAR MATRIX ----------------
        int arr[][] = {
                { 1, 0, 0, 0 },
                { 1, 4, 0, 0 },
                { 4, 6, 2, 0 },
                { 0, 4, 7, 6 } };

        System.out.println("Given matrix -> ");
        check.printMat(arr);

        if (check.isLowerTriangular(arr)) {
            System.out.println("The given matrix is LOWER TRIANGULAR MATRIX");
        } else
            System.out.println("The given mtrix is not a LOWER TRIANGULAR MATRIX");

        // UPPER TRIANGULAR MATRIX ----------------
        int arr2[][] = {
                { 1, 3, 5, 3 },
                { 0, 4, 6, 2 },
                { 0, 0, 2, 5 },
                { 0, 0, 0, 6 }
        };
        System.out.println("Given matrix -> ");
        check.printMat(arr2);

        if (check.isUpperTriangular(arr2))
            System.out.println("The given matrix is UPPER TRIANGULAR MATRIX");
        else
            System.out.println("The given mtrix is not a UPPER TRIANGULAR MATRIX");

        // DIAGONAL MATRIX ----------------
        int arr3[][] = {
                { 1, 0, 1 },
                { 0, 3, 0 },
                { 0, 0, 3 }
        };
        System.out.println("Given matrix -> ");
        check.printMat(arr3);

        if (check.isDiagonal(arr3))
            System.out.println("The given matrix is DIAGONAL MATRIX");
        else
            System.out.println("The given mtrix is not a DIAGONAL MATRIX");

        // IDENTITY MATRIX ----------------
        int arr4[][] = {
                { 1, 0, 1 },
                { 0, 1, 0 },
                { 1, 0, 1 }
        };
        System.out.println("Given matrix -> ");
        check.printMat(arr4);

        if (check.isDiagonal(arr4))
            System.out.println("The given matrix is IDENTITY MATRIX");
        else
            System.out.println("The given mtrix is not a IDENTITY MATRIX");

        // TRIDIAGONAL MATRIX ----------------
        int arr5[][] = {
                { 1, 4, 0, 0 },
                { 3, 4, 1, 0 },
                { 0, 2, 3, 4 },
                { 0, 0, 1, 3 }
        };
        System.out.println("Given matrix -> ");
        check.printMat(arr5);

        if (check.isTridiagonal(arr5))
            System.out.println("The given matrix is TRIDIAGONAL MATRIX");
        else
            System.out.println("The given mtrix is not a TRIDIAGONAL MATRIX");
    }
}
