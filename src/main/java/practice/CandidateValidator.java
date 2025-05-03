package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int VALID_AGE = 35;
    private static final String VALID_NATIONALITY = "Ukrainian";
    private static final int YEARS_TO_LIVE_IN_COUNTRY = 10;

    @Override
    public boolean test(Candidate candidate) {
        if (candidate.getAge() < VALID_AGE
                || !candidate.isAllowedToVote()
                || !candidate.getNationality().equals(VALID_NATIONALITY)) {
            return false;
        }
        String[] fromToInUkraine = candidate.getPeriodsInUkr().split("-");
        return Integer.parseInt(fromToInUkraine[1])
                - Integer.parseInt(fromToInUkraine[0]) >= YEARS_TO_LIVE_IN_COUNTRY;
    }
}
