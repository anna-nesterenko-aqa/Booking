package com.booking.core.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoField;
import java.util.List;

public final class DateUtils {

    private static final List<String> BOOKING_DATE_FORMATS = List.of(
            "EEEE d MMMM yyyy",
            "EEEE, MMMM d, yyyy",
            "EEE, MMM d"
    );

    private DateUtils() {
    }

    public static String retrieveDateFormat(String date) {
        for (String format : BOOKING_DATE_FORMATS) {
            if (isDateOfFormat(date, format)) {
                return format;
            }
        }
        throw new RuntimeException(
                String.format("There is no format for '%s' date among \n'%s'", date, String.join("\n", BOOKING_DATE_FORMATS)));
    }

    public static String nextMonthDateForDay(int day, String format) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        return LocalDateTime.now().plusMonths(1).withDayOfMonth(day).format(formatter);
    }

    private static boolean isDateOfFormat(String date, String format) {
        try {
            DateTimeFormatter formatter = new DateTimeFormatterBuilder()
                    .appendPattern(format)
                    .parseDefaulting(ChronoField.YEAR, LocalDate.now().getYear())
                    .toFormatter();
            LocalDate.parse(date, formatter);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }
}
