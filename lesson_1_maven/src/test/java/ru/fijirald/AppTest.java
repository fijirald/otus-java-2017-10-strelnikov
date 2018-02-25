package ru.fijirald;

import org.junit.Assert;
import org.junit.Test;

public class AppTest {

    @Test
    public void testGetHash() {

        String expectedString = "com.google.common.base.Objects.hashCode(\"a\") = 128";
        String actualString = App.getHash("a");

        Assert.assertEquals(expectedString, actualString);
    }
}
