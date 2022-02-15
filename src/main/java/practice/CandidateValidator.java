package practice;

import java.time.LocalDate;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MINIMUM_AGE = 35;
    private static final int MIN_PERIOD_IN_UKRAINE = 10;
    private static final int INDEX_YEAR_BEGIN = 0;
    private static final int INDEX_CURRENT_YEAR = 1;
    private static final int DAY_IN_YEAR = 1;
    private static final String NATIONALITY = "Ukrainian";
    private static final String REGEX = "-";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MINIMUM_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && getPeriodInUkraine(candidate) >= MIN_PERIOD_IN_UKRAINE;
    }

    private int getPeriodInUkraine(Candidate candidate) {
        String[] split = candidate.getPeriodsInUkr().split(REGEX);
        LocalDate startDate
                = LocalDate.ofYearDay(Integer.parseInt(split[INDEX_YEAR_BEGIN]), DAY_IN_YEAR);
        LocalDate currentDate
                = LocalDate.ofYearDay(Integer.parseInt(split[INDEX_CURRENT_YEAR]), DAY_IN_YEAR);
        return currentDate.compareTo(startDate);
    }
}
