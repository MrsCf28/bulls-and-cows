class EnglishAlphabet {

    public static StringBuilder createEnglishAlphabet() {
        StringBuilder alphabet = new StringBuilder();
        for (int i = 65; i < 90; i++) {
            alphabet.append((char)i + " ");
        }
        alphabet.append("Z");
        return alphabet;
    }
}