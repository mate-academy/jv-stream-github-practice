package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_REQUIRED_AGE = 35;
    private static final int MIN_REQUIRED_PERIOD = 10;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_REQUIRED_AGE && candidate.isAllowedToVote()
                && candidate.getNationality().equals(REQUIRED_NATIONALITY)
                && periodInUkr(candidate) >= MIN_REQUIRED_PERIOD;
    }

    private int periodInUkr(Candidate candidate) {
        String[] splitResult = candidate.getPeriodsInUkr().split("-");
        return Integer.parseInt(splitResult[1]) - Integer.parseInt(splitResult[0]);
    }
}
