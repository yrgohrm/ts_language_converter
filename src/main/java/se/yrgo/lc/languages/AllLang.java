package se.yrgo.lc.languages;

/**
 * The all language takes the first consonant in every word and puts
 * "all" after it. "Hello" thus becomes "Hallello" and "Apes" becomes "Apalles".
 */
public class AllLang implements Language {
        @Override
        public String name() {
            return "all language";
        }
    
        @Override
        public String encode(String text) {
            if (text == null) {
                return null;
            }

            StringBuilder builder = new StringBuilder();
            boolean isNewWord = true;
            for (int i = 0; i < text.length(); ++i) {
                char c = text.charAt(i);
                if (Utils.isConsonant(c) && isNewWord) {
                    builder.append(c).append("all");
                    isNewWord = false;
                }
                else {
                    if (Character.isWhitespace(c)) {
                        isNewWord = true;
                    }
    
                    builder.append(c);
                }
            }
    
            return builder.toString();
        }

        @Override
        public boolean canDecode() {
            return true;
        }

        @Override
        public String decode(String text) {
            StringBuilder builder = new StringBuilder();
            boolean isNewWord = true;
            for (int i = 0; i < text.length(); ++i) {
                char c = text.charAt(i);
                if (Utils.isConsonant(c) && isNewWord) {
                    builder.append(c);
                    i += 3;
                    isNewWord = false;
                }
                else {
                    if (c == ' ') {
                        isNewWord = true;
                    }
    
                    builder.append(c);
                }
            }
    
            return builder.toString();
        }
}
