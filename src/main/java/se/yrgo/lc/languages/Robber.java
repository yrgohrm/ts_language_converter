package se.yrgo.lc.languages;

/**
 * The robber language takes every consonant and doubles it and
 * puts an 'o' in between them. "Hello" thus becomes "Hohelollolo".
 * 
 */
public class Robber implements Language {
    @Override
    public String name() {
        return "robber language";
    }

    @Override
    public boolean canDecode() {
        return true;
    }

    @Override
    public String encode(String text) {
        if (text == null) {
            return null;
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < text.length(); ++i) {
            char c = text.charAt(i);
            if (Utils.isConsonant(c)) {
                builder.append(c).append('o').append(c);
            }
            else {
                builder.append(c);
            }
        }

        return builder.toString();
    }

    @Override
    public String decode(String text) {
        if (text == null) {
            return null;
        }

        StringBuilder builder = new StringBuilder();
        int textLength = text.length();
        for (int i = 0; i < textLength; ++i) {
            char c = text.charAt(i);
            builder.append(c);

            if (Utils.isConsonant(c) && textLength >= i + 2 && text.charAt(i + 1) == 'o'
                    && text.charAt(i + 2) == c) {
                i += 2;
            }
        }

        return builder.toString();
    }
}
