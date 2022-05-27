import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine();

        int discordantCounter = 0;
        int i;

        for (i = 0; i < word.length() - 2; i++) {
            if (isVowel(word, i) && isVowel(word, i + 1) && isVowel(word, i + 2)) {
                discordantCounter++;
                i++;
            }
            if (isConsonant(word, i) && isConsonant(word, i + 1) && isConsonant(word, i + 2)) {
                discordantCounter++;
                i++;
            }
        }
        System.out.println(discordantCounter);
    }

    public static boolean isVowel(String word, int index) {
        String vowels = "aeiouy";
        return vowels.indexOf(word.charAt(index)) != -1;
    }

    public static boolean isConsonant(String word, int index) {
        String consonants = "bcdfghjklmnpqrstvwxz";
        return consonants.indexOf(word.charAt(index)) != -1;
    }
}