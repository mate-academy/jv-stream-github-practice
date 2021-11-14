package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MINIMAL_AGE = 35;
    private static final String NATIONALITY = "Ukrainian";
    private static final int AGES_IN_UKRAINE = 10;

    @Override
    public boolean test(Candidate candidate) {
        if (candidate.getAge() >= MINIMAL_AGE && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)) {
            String[] yearsInUkr = candidate.getPeriodsInUkr().split("-");
            int firstAgeInUkraine = Integer.parseInt(yearsInUkr[0]);
            int lastAgeInUkraine = Integer.parseInt(yearsInUkr[1]);
            return lastAgeInUkraine - firstAgeInUkraine >= AGES_IN_UKRAINE;
        }
        return false;
    }
}
