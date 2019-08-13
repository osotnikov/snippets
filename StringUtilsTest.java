package com.osotnikov.string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class StringUtilsTest {

    @Test
    void compareIgnoreWhitespace_SameObject_Success() {

        String left = "abcd";

        Assertions.assertTrue(StringUtils.equalsIgnoreWhitespace(left, left));
    }

    @Test
    void compareIgnoreWhitespace_BothNull_Success() {

        Assertions.assertTrue(StringUtils.equalsIgnoreWhitespace(null, null));
    }

    @Test
    void compareIgnoreWhitespace_OneObjectOneNull_Failure() {

        String left = "a bc\td\n";

        Assertions.assertFalse(StringUtils.equalsIgnoreWhitespace(left, null));
        Assertions.assertFalse(StringUtils.equalsIgnoreWhitespace(null, left));
    }

    @Test
    void compareIgnoreWhitespace_DifferentContents_Failure() {

        String left = "abcd efg     \n\n\n hijkl";
        String right = "zyx w \t\t\n\t vu t s";

        Assertions.assertFalse(StringUtils.equalsIgnoreWhitespace(left, right));
    }

    @Test
    void compareIgnoreWhitespace_SameContentsSameWs_Success() {

        String left = "abcd efg\n\t\n hijkl";
        String right = "abcd efg\n\t\n hijkl";

        Assertions.assertTrue(StringUtils.equalsIgnoreWhitespace(left, right));
    }

    @Test
    void compareIgnoreWhitespace_SameContentsDifferentWs_Failure() {

        String left =  " abcd efg\t\n\t\nhijkl";
        String right = "abcd efg\n\t\n\t hijkl ";

        Assertions.assertTrue(StringUtils.equalsIgnoreWhitespace(left, right));
    }

    @Test
    void compareIgnoreWhitespaceApartFromNewlines_SameObject_Success() {

        String left = "a bcd\t\nef g\nhij ";

        Assertions.assertTrue(StringUtils.equalsIgnoreWhitespaceApartFromNewlinesButTrim(left, left));
    }

    @Test
    void compareIgnoreWhitespaceApartFromNewlines_BothNull_Success() {

        Assertions.assertTrue(StringUtils.equalsIgnoreWhitespaceApartFromNewlinesButTrim(null, null));
    }

    @Test
    void compareIgnoreWhitespaceApartFromNewlines_OneObjectOneNull_Failure() {

        String left = "a bc\td\n";

        Assertions.assertFalse(StringUtils.equalsIgnoreWhitespaceApartFromNewlinesButTrim(left, null));
        Assertions.assertFalse(StringUtils.equalsIgnoreWhitespaceApartFromNewlinesButTrim(null, left));
    }

    @Test
    void compareIgnoreWhitespaceApartFromNewlines_DifferentContents_Failure() {

        String left = "abcd efg     \n\n\n hijkl";
        String right = "zyx4 w24     \n\n\n 0vuts";

        Assertions.assertFalse(StringUtils.equalsIgnoreWhitespaceApartFromNewlinesButTrim(left, right));
    }

    @Test
    void compareIgnoreWhitespaceApartFromNewlines_SameContentsSameWs_Success() {

        String left = "abcd efg\n\t\n hijkl";
        String right = "abcd efg\n\t\n hijkl";

        Assertions.assertTrue(StringUtils.equalsIgnoreWhitespaceApartFromNewlinesButTrim(left, right));
    }

    @Test
    void compareIgnoreWhitespaceApartFromNewlines_SameContentsSameWsApartFromNewlines_Failure() {

        String left =  " abcd efg\t\n\t\nhijkl";
        String right = "abcd efg\n\t\n\t hijkl ";

        Assertions.assertTrue(StringUtils.equalsIgnoreWhitespaceApartFromNewlinesButTrim(left, right));
    }

    @Test
    void compareIgnoreWhitespaceApartFromNewlines_SameContentsSameWsApartFromNewlines2_Failure() {

        String left =  " abcd efg\t\r\n\t\r\n\n\rhijkl";
        String right = "abcd efg\n\t\n\t\n\r hijkl ";

        Assertions.assertTrue(StringUtils.equalsIgnoreWhitespaceApartFromNewlinesButTrim(left, right));
    }

    @Test
    void compareIgnoreWhitespaceApartFromNewlines_SameContentsDifferentWs_Failure() {

        String left =  " abcd efg\t\n\t\n\thijkl";
        String right = "ab\ncd efg\n\t\n\t  hijkl ";

        Assertions.assertFalse(StringUtils.equalsIgnoreWhitespaceApartFromNewlinesButTrim(left, right));
    }
}
