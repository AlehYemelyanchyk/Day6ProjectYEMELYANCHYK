package by.javatr.task03.service.validation;

import by.javatr.task03.model.Text;

/**
 * @author Aleh Yemelyanchyk on 12/13/2019.
 */
public final class TextServiceValidationUtils {

    private TextServiceValidationUtils() {
    }

    public static boolean isTextNull(Text text) {
        return text != null;
    }

    public static boolean isSubstringNull(String substring) {
        return substring != null;
    }
}
