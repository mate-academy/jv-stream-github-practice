package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int REQUIRED_RESIDENCE_IN_UKRAINE = 10;
    private static final int REQUIRED_MIN_AGE = 35;
    private static final String NATIONALITY = "Ukrainian";
    private static final int INDEX_PERIOD_FROM = 0;
    private static final int INDEX_PERIOD_TO = 1;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= REQUIRED_MIN_AGE
                && candidate.getNationality().equals(NATIONALITY)
                && candidate.isAllowedToVote()
                && getTermOfResidence(candidate) >= REQUIRED_RESIDENCE_IN_UKRAINE;
    }

    private int getTermOfResidence(Candidate candidate) {
        String[] tempPeriod = candidate.getPeriodsInUkr().split("-");
        return Integer.parseInt(tempPeriod[INDEX_PERIOD_TO])
                - Integer.parseInt(tempPeriod[INDEX_PERIOD_FROM]);
    }
}
