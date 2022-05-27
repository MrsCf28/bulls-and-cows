package bullscows;
import java.util.*;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        playGame();
    }

    public static void playGame() {
        int codeLength = getCodeInput();
        if (codeLength == -1) {
            return;
        }
        int numOfSymbols = getNumOfSymbols(codeLength);
        if (numOfSymbols == -1) {
            return;
        }
        String symbolList = createSymbolList(codeLength, numOfSymbols);
        String secretCode = createSecretCode(codeLength, symbolList);
        if (secretCode.equals("Error")) {
            return;
        }
        System.out.println("Okay, let's start a game!");
        int done = 0;

        int turn = 1;
        do {
            System.out.println("Turn " + turn + ":");
            String guessCode = getGuessCode(symbolList, codeLength);
            if (guessCode.equals("Error")) {
                return;
            }
            gradeSecretCode(secretCode, guessCode);
            if (secretCode.equals(guessCode)) {
                done = 1;
            }
            turn++;
        } while (done != 1);

        System.out.println("Congratulations! You have guessed the secret code.");
    }

    public static Boolean isNumeric(String string) {
        return Pattern.matches("\\d+", string);
    }

    public static int getCodeInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input the length of the secret code:");
        String code = scanner.next();

        if (isNumeric(code)) {
            if (code.equals("0") || Integer.parseInt(code) > 36) {
                System.out.println("Error");
                return -1;
            } else {
                return Integer.parseInt(code);
            }
        } else {
            System.out.println("Error: " + code + " isn't a valid number");
            return -1;
        }
    }

    public static int getNumOfSymbols(int codeLength) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input the number of possible symbols in the code:");
        String symbols = scanner.next();

        if (isNumeric(symbols)) {
            int numOfSymbols = Integer.parseInt(symbols);
            if (numOfSymbols < codeLength) {
                System.out.println("Error: it's not possible to generate a code with a length of "
                        + codeLength + " with " + numOfSymbols + " unique symbol(s)." );
                return -1;
            } else if (numOfSymbols > 36) {
                System.out.println("Error: maximum number of symbols in the code is 36 (0-9, a-z).");
                return -1;
            } else {
                return numOfSymbols;
            }
        } else {
            System.out.println("Error: " + symbols + " isn't a valid number");
            return -1;
        }
    }

    public static String createSecretCode(int codeLength, String symbolList) {

        StringBuilder secretCode = new StringBuilder();
        secretCode.append(createRandomSymbol(symbolList));

        for (int i = 1; i < codeLength; i++) {
            char a;
            while (secretCode.length() != i + 1) {
                a = createRandomSymbol(symbolList);
                if (secretCode.indexOf(String.valueOf(a)) == -1) {
                    secretCode.append(a);
                }
            }
        }

        return secretCode.toString();
    }

    public static String createSymbolList(int codeLength, int numOfSymbols) {
        StringBuilder symbols = new StringBuilder();
        for (int i = 0; i < numOfSymbols; i++) {
            if (i < 10) {
                symbols.append((char) (i + 48));
            } else {
                symbols.append((char) (i + 87));
            }
        }
        String symbolsUsed;
        if (numOfSymbols < 11) {
            symbolsUsed = " (0-" + (numOfSymbols - 1) + ")";
        } else if (numOfSymbols == 11) {
            symbolsUsed = " (0-9, a)";
        } else {
            symbolsUsed = " (0-9, a-" + symbols.charAt(numOfSymbols - 1) + ")";
        }

        System.out.println("The secret is prepared: "
                + "*".repeat(codeLength)
                + symbolsUsed);
        return String.valueOf(symbols);
    }

    public static char createRandomSymbol(String symbols) {
        Random random = new Random();
        return symbols.charAt(random.nextInt(symbols.length()));
    }

    public static boolean isBull(String secretCode, String guessCode, int index) {
        return (guessCode.charAt(index) == secretCode.charAt(index));
    }

    public static boolean isCow(String secretCode, String guessCode, int index) {
        return (guessCode.charAt(index) != secretCode.charAt(index)
        && secretCode.indexOf(guessCode.charAt(index)) != -1);
    }

    public static String getGuessCode(String symbolList, int codeLength) {
        Scanner scanner = new Scanner(System.in);
        String guessCode = scanner.next();
        if (guessCode.length() != codeLength) {
            System.out.println("Error: incorrect code length");
            return "Error";
        }
        for (int i = 0; i < guessCode.length(); i++) {
            if (symbolList.indexOf(guessCode.charAt(i)) == -1) {
                System.out.println("Error: incorrect symbols used");
                return "Error";
            }
        }
        return guessCode;
    }

    public static void gradeSecretCode(String secretCode, String guessCode) {
        int bull = 0;
        int cow = 0;
        for (int i = 0; i < secretCode.length(); i++) {
            if (isBull(secretCode, guessCode, i)) {
                bull++;
            } else if (isCow(secretCode, guessCode, i)) {
                cow++;
            }
        }
        String script;

        if (bull == 0 && cow == 0) {
            script = "None.";
        } else if (bull == 0) {
            script = cow + " cow(s).";
        } else if (cow == 0) {
            script = bull + " bull(s).";
        } else {
            script = bull + " bull(s) and " + cow + " cow(s).";
        }
        System.out.println("Grade: " + script);

    }
}
