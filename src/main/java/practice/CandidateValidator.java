package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int AGE_MORE_THAN = 35;
    private static final int RESIDENCE_MORE_THAN = 10;
    private static final String BELONGING_TO_NATIONALITY = "UKRAINIAN";
    private static final String SEPARATOR_SIGN = "-";
    private static final byte PERIOD_TO_INDEX = 1;
    private static final byte PERIOD_FROM_INDEX = 0;

    @Override
    public boolean test(Candidate candidate) {
        String[] splitted = candidate.getPeriodsInUkr().split(SEPARATOR_SIGN);
        int period = Integer.parseInt(splitted[PERIOD_TO_INDEX])
                - Integer.parseInt(splitted[PERIOD_FROM_INDEX]);
        return candidate.isAllowedToVote()
                && candidate.getAge() >= AGE_MORE_THAN
                && candidate.getNationality().equals(BELONGING_TO_NATIONALITY)
                && period >= RESIDENCE_MORE_THAN;
    }
}
