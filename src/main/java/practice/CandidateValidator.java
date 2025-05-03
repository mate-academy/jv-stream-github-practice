package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String REQUIRED_NATIONALITY = "Ukrainian";
    private static final int REQUIRED_AGE = 35;
    private static final int REQUIRED_PERIOD = 10;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= REQUIRED_AGE
                && candidate.getNationality().equals(REQUIRED_NATIONALITY)
                && candidate.isAllowedToVote()
                && (calculateYearsInUkraine(candidate)) >= REQUIRED_PERIOD;
    }

    private int calculateYearsInUkraine(Candidate candidate) {
        return Integer.valueOf(candidate.getPeriodsInUkr().substring(5))
                - Integer.valueOf(candidate.getPeriodsInUkr().substring(0, 4));
    }
}
