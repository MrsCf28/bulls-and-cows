import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

class Main {
    public static void main(String[] args) {
        // put your code here
        // scan the input, add to an empty ArrayList
        ArrayList<Integer> input = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            input.add(scanner.nextInt());
        }

        ArrayList<Integer> elements = new ArrayList<>();
        for (int i = 1; i < input.size(); i += 2) {
            elements.add(input.get(i));
        }

        Collections.reverse(elements);
        for (int element : elements) {
            System.out.print(element + " ");
        }
    }
}