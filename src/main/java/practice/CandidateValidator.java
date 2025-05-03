package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String NATIONALITY = "Ukrainian";
    private static final String PERIOD_SEPARATOR = "-";
    private static final int MIN_AGE = 35;
    private static final int YEARS_OF_LIVING = 10;
    private static final int START_PERIOD = 0;
    private static final int END_PERIOD = 1;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE
                && candidate.getNationality().equals(NATIONALITY)
                && getYearsOfLiving(candidate) >= YEARS_OF_LIVING
                && candidate.isAllowedToVote();
    }

    private int getYearsOfLiving(Candidate candidate) {
        String[] years = candidate.getPeriodsInUkr().split(PERIOD_SEPARATOR);
        return Integer.parseInt(years[END_PERIOD])
                - Integer.parseInt(years[START_PERIOD]);
    }
}
