package org.masingerzero.modernjava.chapter12;



import org.junit.jupiter.api.Assertions;

import java.text.DateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.*;
import java.time.zone.ZoneRules;
import java.util.Date;
import java.util.Locale;
import java.util.Properties;
import java.util.function.UnaryOperator;

public class Chapter12SandBox {

    public static void main(String[] args) {
        LocalDate localDate = LocalDate.ofInstant(Instant.now(), ZoneId.of("Europe/Madrid"));
        System.out.println(localDate);
//        Date

    }



























    public static Temporal nextWorkingDay(Temporal temporal) {
        DayOfWeek dayOfWeek = DayOfWeek.of(temporal.get(ChronoField.DAY_OF_WEEK));
        if (dayOfWeek.equals(DayOfWeek.FRIDAY) || dayOfWeek.equals(DayOfWeek.SATURDAY)) {
            return temporal.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
        }
        return temporal.plus(1, ChronoUnit.DAYS);
    }

    public static TemporalAdjuster nexWorkingDay() {
        return TemporalAdjusters.ofDateAdjuster(localDate -> {
            if (localDate.getDayOfWeek() == DayOfWeek.FRIDAY || localDate.getDayOfWeek() == DayOfWeek.SATURDAY) {
                return localDate.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
            }
            return localDate;
        });

    }


}

class NextWorkingDay implements TemporalAdjuster {
    @Override
    public Temporal adjustInto(Temporal temporal) {
        DayOfWeek dayOfWeek = DayOfWeek.of(temporal.get(ChronoField.DAY_OF_WEEK));
        if (dayOfWeek.equals(DayOfWeek.FRIDAY)) {
            return temporal.plus(3, ChronoUnit.DAYS);
        } else if (dayOfWeek.equals(DayOfWeek.SATURDAY)) {
            return temporal.plus(2, ChronoUnit.DAYS);
        }
        return temporal.plus(1, ChronoUnit.DAYS);
    }
}
class NextWorkingDayV2 implements TemporalAdjuster {
    @Override
    public Temporal adjustInto(Temporal temporal) {
        DayOfWeek dayOfWeek = DayOfWeek.of(temporal.get(ChronoField.DAY_OF_WEEK));
        switch (dayOfWeek) {
            case FRIDAY: return temporal.plus(3, ChronoUnit.DAYS);
            case SATURDAY:return temporal.plus(2, ChronoUnit.DAYS);
        }
        return temporal.plus(1, ChronoUnit.DAYS);
    }
}

class NextWorkingDayV3 implements TemporalAdjuster {
    @Override
    public Temporal adjustInto(Temporal temporal) {
        DayOfWeek dayOfWeek = DayOfWeek.of(temporal.get(ChronoField.DAY_OF_WEEK));
        if (dayOfWeek.equals(DayOfWeek.FRIDAY) || dayOfWeek.equals(DayOfWeek.SATURDAY)) {
            return temporal.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
        }
        return temporal.plus(1, ChronoUnit.DAYS);
    }
}

