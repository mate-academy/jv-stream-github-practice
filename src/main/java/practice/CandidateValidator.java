package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";
    private static final int MIN_YEARS = 10;

    @Override
    public boolean test(Candidate candidate) {
        if (candidate == null) {
            return false;
        }
        if (candidate.getAge() < MIN_AGE) {
            return false;
        }
        if (!candidate.isAllowedToVote()) {
            return false;
        }
        if (!candidate.getNationality().equals(REQUIRED_NATIONALITY)) {
            return false;
        }
        String yearsInUkraine = candidate.getPeriodsInUkr();
        return Integer.parseInt(yearsInUkraine.substring(yearsInUkraine.indexOf("-") + 1))
                - Integer.parseInt(yearsInUkraine.substring(0, yearsInUkraine.indexOf("-")))
                >= MIN_YEARS;
    }
}
