package se.yrgo.lc.languages;

public final class Utils {
    private Utils() {}

    public static boolean isVowel(char c) {
        return "aouåeiyäöAOUÅEIÄÖ".indexOf(c) != -1;
    }

    public static boolean isConsonant(char c) {
        return !isVowel(c) && Character.isLetter(c);
    }
}
