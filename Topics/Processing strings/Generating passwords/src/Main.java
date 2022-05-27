import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();
        int numOfUppercase = scanner.nextInt();
        int numOfLowercase = scanner.nextInt();
        int numOfDigits = scanner.nextInt();
        int totalNumOfSymbols = scanner.nextInt();
        final int numOfSwitchCases = 3;

        while (numOfUppercase + numOfLowercase + numOfDigits < totalNumOfSymbols) {
            switch (rand.nextInt(numOfSwitchCases)) {
                case 0:
                    numOfUppercase++;
                    break;
                case 1:
                    numOfLowercase++;
                    break;
                default:
                    numOfDigits++;
                    break;
            }
        }

        StringBuilder password = getPassword(numOfUppercase, numOfLowercase, numOfDigits, totalNumOfSymbols);

        System.out.println(password);
    }

    public static StringBuilder getPassword(int numOfUppercase,
                                            int numOfLowercase,
                                            int numOfDigits,
                                            int totalNumOfSymbols) {
        Random rand = new Random();
        final int numOfSwitchCases = 3;
        StringBuilder password = new StringBuilder();
        int uppercaseRemaining = numOfUppercase;
        int lowercaseRemaining = numOfLowercase;
        int digitsRemaining = numOfDigits;

        while (password.length() != totalNumOfSymbols) {
            switch (rand.nextInt(numOfSwitchCases)) {
                case 0:
                    if (uppercaseRemaining != 0) {
                        char nextUppercase = randUpperChar();
                        if (password.length() != 0) {
                            while (password.charAt(password.length() - 1) == nextUppercase) {
                                nextUppercase = randUpperChar();
                            }
                        }
                        password.append(nextUppercase);
                        uppercaseRemaining--;
                    }
                    break;
                case 1:
                    if (lowercaseRemaining != 0) {
                        char nextLowercase = randLowerChar();
                        if (password.length() != 0) {
                            while (password.charAt(password.length() - 1) == nextLowercase) {
                                nextLowercase = randLowerChar();
                            }
                        }
                        password.append(nextLowercase);
                        lowercaseRemaining--;
                    }
                    break;
                default:
                    if (digitsRemaining != 0) {
                        char nextDigit = randDigit();
                        if (password.length() != 0) {
                            while (password.charAt(password.length() - 1) == nextDigit) {
                                nextDigit = randDigit();
                            }
                        }
                        password.append(nextDigit);
                        digitsRemaining--;
                    }
                    break;
            }
        }
        return password;
    }

    public static char randUpperChar() {
        Random rand = new Random();
        final int alphabet = 26;
        String uppercaseChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        return uppercaseChars.charAt(rand.nextInt(alphabet));
    }

    public static char randLowerChar() {
        Random rand = new Random();
        final int alphabet = 26;
        String lowercaseChars = "abcdefghijklmnopqrstuvwxyz";
        return lowercaseChars.charAt(rand.nextInt(alphabet));
    }

    public static char randDigit() {
        Random rand = new Random();
        final int digits = 10;
        String digitChars = "0123456789";
        return digitChars.charAt(rand.nextInt(digits));

    }
}

