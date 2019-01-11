import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numNodes = scanner.nextInt();
        QuickUnionUF qf = new QuickUnionUF(numNodes);

        qf.printNodes();
        while (scanner.hasNext()) {
            int p = scanner.nextInt();
            int q = scanner.nextInt();
            if (!qf.connected(p, q)) {
                qf.union(p, q);
                System.out.println(p + "-" + q);
            }
            qf.printNodes();
        }

    }
}
