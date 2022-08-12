package se.yrgo.lc.languages;

/**
 * Interface for a translator of a language.
 * 
 */
public interface Language {
    /**
     * The name of the language, in all lower letters.
     * 
     * @return the name of the language
     */
    String name();

    /**
     * If this language can be perfectly decoded back to the original.
     * Should return true if the language can be perfectly decoded
     * back to the original. I.e. x.equals(decode(encode(x))) for all
     * non-null strings.
     * 
     * @return true if it can be decoded.
     */
    boolean canDecode();

    /**
     * Encode a given string to the language.
     * 
     * 
     * @param text the text to be encoded
     * @return text translated to the language or null if text was null
     */
    String encode(String text);

    /**
     * Decode a string in the given language back to the original.
     * 
     * @param text the text to be decoded
     * @return text translated from the language or null if text was null
     */
    String decode(String text);
}
