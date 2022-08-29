package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final String NATIONALITY = "Ukrainian";
    private static final int MIN_PERIOD_IN_COUNTRY = 10;
    private static final int FROM_INDEX = 0;
    private static final int TO_INDEX = 1;

    @Override
    public boolean test(Candidate candidate) {
        String[] splitPeriod = candidate.getPeriodsInUkr().split("-");
        int period = Integer.parseInt(splitPeriod[TO_INDEX])
                - Integer.parseInt(splitPeriod[FROM_INDEX]);
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && period >= MIN_PERIOD_IN_COUNTRY;
    }
}
