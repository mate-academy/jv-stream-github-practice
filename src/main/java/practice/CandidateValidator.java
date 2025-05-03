package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String PROPER_NATIONALITY = "Ukrainian";
    private static final String DELIMITER = "-";
    private static final int MIN_AGE = 35;
    private static final int MIN_LIVING_PERIOD_IN_UKRAINE = 10;
    private static final int START_YEAR_INDEX = 0;
    private static final int FINAL_YEAR_INDEX = 1;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE
                && candidate.getNationality().equals(PROPER_NATIONALITY)
                && candidate.isAllowedToVote()
                && calculatePeriodInUkr(candidate.getPeriodsInUkr())
                >= MIN_LIVING_PERIOD_IN_UKRAINE;
    }

    private int calculatePeriodInUkr(String period) {
        String[] firstAndLastYear = period.split(DELIMITER);
        return Integer.parseInt(firstAndLastYear[FINAL_YEAR_INDEX])
                - Integer.parseInt(firstAndLastYear[START_YEAR_INDEX]);
    }
}
