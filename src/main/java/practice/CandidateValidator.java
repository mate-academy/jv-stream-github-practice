package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int MIN_YEARS_IN_UKRAINE = 10;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";
    private static final String PERIOD_SEPARATOR = "-";
    private static final int PERIOD_START_INDEX = 0;
    private static final int PERIOD_END_INDEX = 1;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && REQUIRED_NATIONALITY.equals(candidate.getNationality())
                && getYearsInUkraine(candidate.getPeriodsInUkr()) >= MIN_YEARS_IN_UKRAINE;
    }

    private int getYearsInUkraine(String periodInUkraine) {
        String[] years = periodInUkraine.split(PERIOD_SEPARATOR);
        return Integer.parseInt(years[PERIOD_END_INDEX])
                - Integer.parseInt(years[PERIOD_START_INDEX]);
    }
}
