package se.yrgo.lc.languages;

/**
 * Convert text to base64.
 * 
 */
public class Base64 implements Language {
    private static final char[] toBase64 =
            {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q',
                    'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g',
                    'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w',
                    'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};

    @Override
    public String encode(String text) {
        final StringBuilder output = new StringBuilder();
        final byte[] data = text.getBytes();

        int padding = 0;
        for (int i = 0; i < data.length; i += 3) {
            int b = ((data[i] & 0xFF) << 16) & 0xFFFFFF;
            if (i + 1 < data.length) {
                b |= (data[i + 1] & 0xFF) << 8;
            }
            else {
                padding++;
            }

            if (i + 2 < data.length) {
                b |= (data[i + 2] & 0xFF);
            }
            else {
                padding++;
            }

            for (int j = 0; j < 4 - padding; j++) {
                int ci = (b & 0xFC0000) >> 18;
                output.append(toBase64[ci]);
                b <<= 6;
            }
        }

        for (int i = 0; i < padding; i++) {
            output.append("=");
        }

        return output.toString();
    }

    @Override
    public String name() {
        return "base 64";
    }

    @Override
    public boolean canDecode() {
        return false;
    }

    @Override
    public String decode(String text) {
        throw new UnsupportedOperationException();
    }
}
