import java.util.Scanner;

class ConcatenateStringsProblem {

    public static String concatenateStringsWithoutDigits(String[] strings) {
        String newString = String.join("", strings);
        StringBuilder joinedString = new StringBuilder(newString);
        String digitChars = "0123456789";
        int i;

        for (i = 0; i < joinedString.length(); i++) {
            char a = joinedString.charAt(i);
            if (digitChars.contains(String.valueOf(a))) {
                joinedString.deleteCharAt(i);
                i--;
            }
        }
        return String.valueOf(joinedString);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] strings = scanner.nextLine().split("\\s+");
        String result = concatenateStringsWithoutDigits(strings);
        System.out.println(result);
    }
}