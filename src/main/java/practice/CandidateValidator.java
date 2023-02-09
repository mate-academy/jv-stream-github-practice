package practice;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int AGE_LIMIT = 35;
    private static final int YEAR_LIMIT = 10;

    @Override
    public boolean test(Candidate candidate) {
        return (candidate.getAge() >= AGE_LIMIT && candidate.isAllowedToVote()
                && candidate.getNationality().equals("Ukrainian")
                && livedInUkraineLastTenYears(candidate.getPeriodsInUkr()));
    }

    private boolean livedInUkraineLastTenYears(String periodsInUkr) {
        DateTimeFormatter formatter = new DateTimeFormatterBuilder()
                .appendPattern("yyyy")
                .parseDefaulting(ChronoField.MONTH_OF_YEAR, 1)
                .parseDefaulting(ChronoField.DAY_OF_MONTH, 1)
                .toFormatter();

        int indexDash = periodsInUkr.indexOf("-");
        LocalDate startDate = LocalDate.parse(periodsInUkr.substring(0, indexDash), formatter);
        LocalDate endDate = LocalDate.parse(periodsInUkr.substring(indexDash + 1), formatter);
        Period period = Period.between(startDate, endDate);
        System.out.println(period.getYears());
        return period.getYears() >= YEAR_LIMIT;
    }
}
