import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("");
        int firstHalfSum = Integer.parseInt(input[0]) + Integer.parseInt(input[1]) + Integer.parseInt(input[2]);
        int secondHalfSum = Integer.parseInt(input[3]) + Integer.parseInt(input[4]) + Integer.parseInt(input[5]);

        if (firstHalfSum == secondHalfSum) {
            System.out.println("Lucky");
        } else {
            System.out.println("Regular");
        }
    }
}