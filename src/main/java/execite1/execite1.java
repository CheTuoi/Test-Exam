import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

public class execite1 {
    public static int getDaysBetweenDates(String startDate, String closeDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        LocalDate start = LocalDate.parse(startDate, formatter);
        LocalDate close = LocalDate.parse(closeDate, formatter);
        return (int) ChronoUnit.DAYS.between(start, close);
    }

    public static String addMonths(String startDate, int months){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        LocalDate start = LocalDate.parse(startDate, formatter);
        LocalDate end = start.plusMonths(months);
        end = end.with(TemporalAdjusters.lastDayOfMonth());
        return end.format(formatter);
    }
}
