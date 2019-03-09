package com.smalaca;

import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CourseTest {

    private static final String ANY_COURSE_NAME = "Course Name";

    @Test
    public void shouldHaveTheSameName() {
        Course course = new Course(ANY_COURSE_NAME, LocalDate.now());

        String result = course.name();

        assertEquals(ANY_COURSE_NAME, result);
    }

    @Test
    public void shouldHaveStartedBeforeGivenDate() {
        Course course = new Course(ANY_COURSE_NAME, LocalDate.of(2019, 3, 1));
        LocalDate presentDate = LocalDate.now();

        boolean result = course.wasStartedBefore(presentDate);

        assertTrue(result);
    }

    @Test
    public void shouldHaveStartDateNotBefore() {
        Course course = new Course(ANY_COURSE_NAME, LocalDate.of(2019, 3, 1));
        LocalDate presentDate = LocalDate.of(2018, 3, 1);

        boolean result = course.wasStartedBefore(presentDate);

        assertFalse(result);
    }
}