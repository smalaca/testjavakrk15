package com.smalaca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PersonTest {

    @Test
    public void shouldReturnFullName() {
        Person person = new Person("Sebastian", "Malaca");

        String fullName = person.fullName();

        assertEquals("Sebastian Malaca", fullName);
    }

    @Test
    public void shouldHasFullNameWhenFirstAndSecondNameGiven() {
       //given
        Person person = new Person("Sebastian", "Malaca");

        //when
        boolean result = person.hasFullName();

        //then
        assertTrue(result);
    }

    @Test
    public void shouldHasNoFullNameWhenNothingGiven() {
        //given
        Person person = new Person();

        //when
        boolean result = person.hasFullName();

        //then
        assertFalse(result);
    }
}






