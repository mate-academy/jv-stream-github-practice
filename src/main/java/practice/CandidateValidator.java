package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int ACCEPTABLE_AGE = 35;
    private static final String ACCEPTABLE_NATIONALITY = "Ukrainian";
    private static final int ACCEPTABLE_LIVING_PERIOD = 10;
    private static final String DELIMITER = "-";
    private static final int FROM_INDEX = 0;
    private static final int TO_INDEX = 1;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= ACCEPTABLE_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(ACCEPTABLE_NATIONALITY)
                && calculateRange(candidate.getPeriodsInUkr()) >= ACCEPTABLE_LIVING_PERIOD;
    }

    private int calculateRange(String period) {
        String[] splitPeriod = period.split(DELIMITER);
        return Integer.parseInt(splitPeriod[TO_INDEX]) - Integer.parseInt(splitPeriod[FROM_INDEX]);
    }
}
