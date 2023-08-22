
public class TowerOfHanoi {

    static public void tower(int n, String source, String mid, String dest) {
        if (n == 0) {
            System.out.println("Move disk 0 from " + source + " to " + dest);
            return;
        }

        tower(n - 1, source, mid, dest);
        System.out.println("Move disk " + n + " from " + source + " to " + dest);
        tower(n - 1, mid, dest, source);
    }

    public static void main(String[] args) {

        // n is the number of disks
        tower(4, "A", "B", "C");
    }

}