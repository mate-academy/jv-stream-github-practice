package practice;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_CANDIDATE_AGE = 35;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";
    private static final int MIN_YEAR = 10;
    private static final DateTimeFormatter FORMATTER = new DateTimeFormatterBuilder()
            .appendPattern("yyyy")
            .parseDefaulting(ChronoField.MONTH_OF_YEAR, 1)
            .parseDefaulting(ChronoField.DAY_OF_MONTH, 1)
            .toFormatter();

    @Override
    public boolean test(Candidate candidate) {
        return (candidate.getAge() >= MIN_CANDIDATE_AGE && candidate.isAllowedToVote()
                && candidate.getNationality().equals(REQUIRED_NATIONALITY)
                && getPeriodInUkraine(candidate) >= MIN_YEAR);
    }

    private int getPeriodInUkraine(Candidate candidate) {
        String periodsInUkr = candidate.getPeriodsInUkr();
        String[] arrayPeriods = periodsInUkr.split("-");
        LocalDate startDate = LocalDate.parse(arrayPeriods[0], FORMATTER);
        LocalDate endDate = LocalDate.parse(arrayPeriods[1], FORMATTER);
        Period period = Period.between(startDate, endDate);
        return period.getYears();
    }
}
