package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int INDEX_ZERO = 0;
    private static final int INDEX_ONE = 1;
    private static final String DASH_REGEX = "-";

    @Override
    public boolean test(Candidate candidate) {
        String[] periodInUkr = candidate.getPeriodsInUkr().split(DASH_REGEX);
        int period = Integer.parseInt(periodInUkr[INDEX_ONE])
                - Integer.parseInt(periodInUkr[INDEX_ZERO]);
        return candidate.getAge() >= 35 && candidate.isAllowedToVote()
                && candidate.getNationality().equals("Ukrainian")
                && period >= 10;
    }
}
