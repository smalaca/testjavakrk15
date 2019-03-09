package com.smalaca.foobar;

public class FooBar {
    private final int integer;

    public FooBar(int integer) {
        this.integer = integer;
    }

    public String asString() {

        if (integer % 15 == 0) {
            return "FooBar";
        } else if (integer % 3 == 0) {
            return "Foo";
        } else if (integer % 5 == 0) {
            return "Bar";
        }

        return String.valueOf(integer);
    }
}
