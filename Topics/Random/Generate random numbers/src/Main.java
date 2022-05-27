import java.util.*;

public class Main {
    public static void main(String[] args) {
        /* Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        Random random = new Random(a + b);
        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += random.nextInt(b - a + 1) + a;
        }
        System.out.println(sum);
         */

        Random generator = new Random();
        int a = generator.nextInt(3);
        int b = generator.nextInt(2) + 1;
        int c = generator.nextInt(4);
        System.out.println(a + " " + b + " " + c);
    }
}