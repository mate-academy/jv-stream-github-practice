package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int ADULT_AGE = 35;
    private static final int YEARS_LIVING_IN_UKRAINE = 10;
    private static final String NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        if (candidate.getAge() < ADULT_AGE || !candidate.getNationality().equals(NATIONALITY)
                || !candidate.isAllowedToVote()) {
            return false;
        }
        String[] data = candidate.getPeriodsInUkr().split("-");
        return Integer.parseInt(data[1]) - Integer.parseInt(data[0]) > YEARS_LIVING_IN_UKRAINE;
    }
}
