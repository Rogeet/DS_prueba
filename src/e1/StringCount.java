package e1;

import java.util.Locale;

public class StringCount {

    public static int countWords(String text) {
        if ((text == null) || (text.trim().isEmpty())) {
            return 0;
        } else {
            int i, words = 0;
            boolean flag = true;
            for (i = 0; i <= text.length(); i++) {
                if (text.charAt(i) != ' ' && flag) {
                    words++;
                    flag = false;
                } else if (text.charAt(i) == ' ') {
                    flag = true;
                }
            }
            return (words);
        }
    }

    public static int countChar(String text, char c) {
        if ((text == null) || (text.trim().isEmpty())) {
            return 0;
        } else {
            int i, x = 0;
            for (i = 0; i <= text.length(); i++) {
                if (text.charAt(i) == c) {
                    x++;
                }
            }
            return (x);
        }
    }

    public static int countCharIgnoringCase(String text, char c) {
        if ((text == null) || (text.trim().isEmpty())) {
            return 0;
        } else {
            int i, x = 0;
            for (i = 0; i <= text.length(); i++) {
                if (text.toLowerCase().charAt(i) == c || text.toUpperCase().charAt(i) == c) {
                    x++;
                }
            }
            return (x);
        }
    }

    public static boolean isPasswordSafe(String password) {
        if (password.length() >= 8) {
            int i;
            boolean x = false, y = false, z = false, k = false;
            for (i = 0; i <= password.length(); i++) {
                if (Character.isUpperCase(password.charAt(i))) {
                    x = true;
                } else if (Character.isLowerCase(password.charAt(i))) {
                    y = true;
                } else if (Character.isDigit(password.charAt(i))) {
                    z = true;
                } else if (password.charAt(i) == '?' || password.charAt(i) == '@' || password.charAt(i) == '#' || password.charAt(i) == '$' || password.charAt(i) == '.' || password.charAt(i) == ',') {
                    k = true;
                }
            }
            return (x && y && z && k);
        }
        return false;
    }
}
