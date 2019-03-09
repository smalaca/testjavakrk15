package com.smalaca.foobar;

public class FooBar {
    private final int integer;

    public FooBar(int integer) {
        this.integer = integer;
    }

    public String asString() {
        return String.valueOf(integer);
    }
}
