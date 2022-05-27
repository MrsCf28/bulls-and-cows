import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Arrays;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<String> companies = new ArrayList<>(Arrays.asList(input.split(" ")));
        System.out.println(companies);
    }
}