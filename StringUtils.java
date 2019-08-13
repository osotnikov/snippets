package com.osotnikov.string;

public class StringUtils {

    public static boolean equalsIgnoreWhitespace(String left, String right) {

        if(left == right) {
            return true;
        } else if(left == null || right == null) {
            return false;
        } else {
            left = left.replaceAll("\\s+","");
            right = right.replaceAll("\\s+","");

            return left.equals(right);
        }
    }

    public static boolean equalsIgnoreWhitespaceApartFromNewlinesButTrim(String left, String right) {

        if(left == right) {
            return true;
        } else if(left == null || right == null) {
            return false;
        } else {
            left = left.replaceAll("\\r\\n","\n").trim();
            right = right.replaceAll("\\r\\n","\n").trim();

            left = left.replaceAll("[^\\S\\r\\n]+","");
            right = right.replaceAll("[^\\S\\r\\n]+","");

            return left.equals(right);
        }
    }
}
