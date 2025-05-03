package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String COUNTRY = "Ukrainian";
    private static final String DASH = "-";
    private static final int ZERO = 0;
    private static final int ONE = 1;
    private static final int MIN_AGE = 35;
    private static final int MIN_LIVE_AGE = 10;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE
                && candidate.getNationality().equals(COUNTRY)
                && candidate.isAllowedToVote()
                && checkYear(candidate);
    }

    private boolean checkYear(Candidate candidate) {
        String[] ages = candidate.getPeriodsInUkr().split(DASH);
        return Integer.parseInt(ages[ONE])
                - Integer.parseInt(ages[ZERO]) >= MIN_LIVE_AGE;
    }
}
