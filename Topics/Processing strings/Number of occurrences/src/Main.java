import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String currentInput = scanner.nextLine();
        String subString = scanner.nextLine();
        int counter = 0;
        int substringStartingIndex;
        int substringEnd;

        while (currentInput.contains(subString)) {
            if (currentInput.contains(subString)) {
                counter++;
                substringStartingIndex = currentInput.indexOf(subString);
                substringEnd = substringStartingIndex + subString.length();
                currentInput = currentInput.substring(0, substringStartingIndex) + currentInput.substring(substringEnd);
            }
        }

        System.out.println(counter);
    }
}