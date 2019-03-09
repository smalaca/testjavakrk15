package com.smalaca.foobar;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FooBarTest {

    @Test
    public void shouldReturnStringWhenIntGiven() {
        int anyInt = 16;
        String anyIntAsString = "16";
        FooBar fooBar = new FooBar(anyInt);

        String result = fooBar.asString();

        assertEquals(anyIntAsString, result);
    }

    @Test
    public void shouldReturnStringWhenDifferentIntGiven() {
        int anyInt = 13;
        String anyIntAsString = "13";
        FooBar fooBar = new FooBar(anyInt);

        String result = fooBar.asString();

        assertEquals(anyIntAsString, result);
    }

    @Test
    public void shouldReturnFooWhenNumberIsDivisibleByThree() {
        int divisibleByThree = 69;
        FooBar fooBar = new FooBar(divisibleByThree);

        String result = fooBar.asString();

        assertEquals("Foo", result);
    }

    @Test
    public void shouldReturnBarWhenNumberIsDivisibleByFive() {
        int divisibleByFive = 25;
        FooBar fooBar = new FooBar(divisibleByFive);

        String result = fooBar.asString();

        assertEquals("Bar", result);
    }

    @Test
    public void shouldReturnFooBarWhenNumberIsDivisibleByFifteen() {
        int divisibleByFifteen = 30;
        FooBar fooBar = new FooBar(divisibleByFifteen);

        String result = fooBar.asString();

        assertEquals("FooBar", result);
    }
}
