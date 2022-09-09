package practice;

import model.Candidate;
import java.util.function.Predicate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int MIN_LIVING_PERIOD = 10;
    private static final String NATIONALITY = "Ukrainian";
    private static final String SPLIT_REGEXP = "-";
    private static final int START_YEAR_INDEX = 0;
    private static final int LAST_YEAR_INDEX = 1;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.isAllowedToVote()
                && candidate.getAge() >= MIN_AGE
                && candidate.getNationality().equals(NATIONALITY)
                && calculateLivingPeriod(candidate.getPeriodsInUkr()) >= MIN_LIVING_PERIOD;
    }

    private int calculateLivingPeriod(String period) {
        String[] splitArray = period.split(SPLIT_REGEXP);
        return Integer.parseInt(splitArray[LAST_YEAR_INDEX])
                - Integer.parseInt(splitArray[START_YEAR_INDEX]);
    }
}
