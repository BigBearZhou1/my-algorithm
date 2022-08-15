package algorithm.tree;

/**
 * 打印对折折痕
 */
public class PaperFolding {
    public static void printAllFolds(int N) {
        printProcess(1, N, true);
    }

    private static void printProcess(int i, int n, boolean b) {
        if (i > n) {
            return;
        }
        printProcess(i + 1, n, true);
        System.out.println(b ? "down" : "up");
        printProcess(i + 1, n, false);
    }

    public static void main(String[] args) {
        printAllFolds(2);
    }
}
