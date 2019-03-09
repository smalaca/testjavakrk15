package com.smalaca;

import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

public class CourseTest {
    @Test
    public void shouldHaveTheSameName() {
        String anyName = "Course Name";
        Course course = new Course(anyName, LocalDate.now());

        String result = course.name();

        assertEquals(anyName, result);
    }

    @Test
    public void shouldHaveStartDateBefore() {

    }

    @Test
    public void shouldHaveStartDateNotBefore() {

    }
}