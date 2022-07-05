package se.yrgo.libraryapp.validator;

import java.util.regex.Pattern;

/**
 * This validator checks that the username match our high standard for proper names.
 * 
 * I.e. no funny characters or whitespace and at least four characters long.
 */
public final class Username {
    private static Pattern regex = Pattern.compile("[@._a-zA-Z0-]{4,}");

    private Username() {}

    public static boolean validate(String name) {
        return regex.matcher(name).matches();
    }
}
