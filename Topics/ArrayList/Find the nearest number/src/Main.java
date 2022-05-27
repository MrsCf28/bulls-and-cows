import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // scan the input, add to an empty ArrayList
        ArrayList<Integer> input = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            input.add(scanner.nextInt());
        }

        Integer n = input.get(input.size() - 1); // get the N number "n"
        // make a new list, remove N and sort into ascending order
        ArrayList<Integer> elements = new ArrayList<>(input);
        elements.remove(input.size() - 1);
        Collections.sort(elements);

        int counter = 0;

        // check each distance between the numbers and N, print those numbers.
        // once all numbers of those distances are printed, break out of the loop.
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            for (Integer num : elements) {
                if (num - n == i || n - num == i) {
                    System.out.print(num + " ");
                    counter++;
                }
            }
            if (counter != 0) {
                break;
            }
        }
    }
}