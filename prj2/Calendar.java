package prj2;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.TextStyle;
import java.util.Locale;

public class Calendar {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        YearMonth yearMonth = YearMonth.of(today.getYear(), today.getMonth());
        String monthName = today.getMonth().getDisplayName(TextStyle.FULL, Locale.getDefault());
        int daysInMonth = yearMonth.lengthOfMonth();

        System.out.printf("     %s %d%n", monthName, today.getYear());
        System.out.println("Su Mo Tu We Th Fr Sa");

        // Find out the day of week of the 1st of the month (1=Monday, 7=Sunday)
        int firstDayOfWeek = yearMonth.atDay(1).getDayOfWeek().getValue();
        // Adjust for Sunday as first day (Java's DayOfWeek: 7=Sunday)
        int startColumn = firstDayOfWeek % 7;

        // Print leading spaces
        for (int i = 0; i < startColumn; i++) {
            System.out.print("   ");
        }

        // Print days of the month
        for (int day = 1; day <= daysInMonth; day++) {
            System.out.printf("%2d ", day);
            if ((day + startColumn) % 7 == 0) {
                System.out.println();
            }
        }
        System.out.println();
        System.out.println("Today is: " +
                today.format(java.time.format.DateTimeFormatter
                        .ofLocalizedDate(java.time.format.FormatStyle.LONG)
                        .withLocale(Locale.getDefault())));
    }
}