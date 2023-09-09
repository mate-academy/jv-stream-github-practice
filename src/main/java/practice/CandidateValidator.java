package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int VALID_AGE = 35;
    private static final int VALID_PERIOD = 10;
    private static final String NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getNationality().equals(NATIONALITY)
                && candidate.isAllowedToVote()
                && candidate.getAge() >= VALID_AGE
                && getYearsInUkr(candidate) >= VALID_PERIOD;
    }

    private int getYearsInUkr(Candidate candidate) {
        String[] periodString = candidate.getPeriodsInUkr().split("-");
        return Integer.parseInt(periodString[1]) - Integer.parseInt(periodString[0]);
    }
}
