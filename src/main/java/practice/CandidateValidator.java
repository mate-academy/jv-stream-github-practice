package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String NATIONALITY_UKRAINIAN = "Ukrainian";
    private static final int MIN_AGE = 35;
    private static final int MIN_YEARS_IN_UKRAINE = 10;
    private static final String DELIMITER = "-";
    private static final int START_PERIOD_INDEX = 0;
    private static final int END_PERIOD_INDEX = 1;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && NATIONALITY_UKRAINIAN.equals(candidate.getNationality())
                && calculateYearsInUkraine(candidate.getPeriodsInUkr()) >= MIN_YEARS_IN_UKRAINE;
    }

    private int calculateYearsInUkraine(String periodsInUkr) {
        String[] periods = periodsInUkr.split(DELIMITER);
        return Integer.parseInt(periods[END_PERIOD_INDEX])
                - Integer.parseInt(periods[START_PERIOD_INDEX]);
    }
}
