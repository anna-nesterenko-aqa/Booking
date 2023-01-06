package com.booking.core.utils;

public final class StringsHelper {

    private StringsHelper() {
    }

    public static String splitByNewLineAndGetLastElement(String string) {
        String[] splitString = string.split("\n");
        return splitString[splitString.length - 1];
    }
}
