package utils;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Check {
    public static boolean isNullOrEmpty(String string) {
        return string == null || string.isEmpty() || string.isBlank();
    }

    public static boolean hasElements(List list) {
        return list != null && !list.isEmpty();
    }

    public static boolean isValidEmail(String email) {
        if (!isNullOrEmpty(email)) {
            String pattern = "^[\\d\\w\\.]+@[\\d\\w\\.]+\\..{2,4}$";
            Pattern emailPattern = Pattern.compile(pattern);
            Matcher match = emailPattern.matcher(email);
            return match.find();
        }
        return false;
    }
}
