package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {

    private static final int MIN_AGE = 35;
    private static final int MIN_PERIOD = 10;
    private static final String UKRAINIAN = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        if (candidate.getAge() < MIN_AGE) {
            return false;
        }
        if (!candidate.isAllowedToVote()) {
            return false;
        }
        if (!UKRAINIAN.equals(candidate.getNationality())) {
            return false;
        }
        String[] parts = candidate.getPeriodsInUkr().split("-");
        return Integer.parseInt(parts[1]) - Integer.parseInt(parts[0]) >= MIN_PERIOD;
    }
}
