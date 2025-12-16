package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int REQUIRED_AGE = 35;
    private static final int REQUIRED_YEARS_IN_UKR = 10;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        if (candidate.getAge() < REQUIRED_AGE) {
            return false;
        }
        if (!candidate.isAllowedToVote()) {
            return false;
        }
        if (!candidate.getNationality().equals(REQUIRED_NATIONALITY)) {
            return false;
        }
        String[] parts = candidate.getPeriodsInUkr().split("-");
        return Integer.parseInt(parts[1]) - Integer.parseInt(parts[0]) >= REQUIRED_YEARS_IN_UKR;
    }
}
