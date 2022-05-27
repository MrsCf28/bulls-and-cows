import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sizeOfArray = scanner.nextInt();
        scanner.nextLine();
        String inputLine = scanner.nextLine();
        String[] inputArray = inputLine.split(" ");
        int n = scanner.nextInt();
        int counter = 0;

        for (int i = 0; i < sizeOfArray; i++) {
            if (n == Integer.parseInt(inputArray[i])) {
                counter++;
            }
        }

        System.out.println(counter);
    }
}