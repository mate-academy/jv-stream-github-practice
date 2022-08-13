package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int INDEX_FROM_YEAR_IN_UKRAINE = 0;
    private static final int INDEX_TILL_YEAR_IN_UKRAINE = 1;
    private static final int MIN_REQUIRED_YEARS_IN_UKRAINE = 10;
    private static final int MIN_REQUIRED_AGE = 35;

    @Override
    public boolean test(Candidate candidate) {
        if (candidate.getAge() < MIN_REQUIRED_AGE) {
            return false;
        }
        if (!candidate.isAllowedToVote()) {
            return false;
        }
        if (!candidate.getNationality().equals("Ukrainian")) {
            return false;
        }
        return ((Integer.parseInt(candidate.getPeriodsInUkr()
                .split("-")[INDEX_TILL_YEAR_IN_UKRAINE])
                - Integer.parseInt(candidate.getPeriodsInUkr()
                .split("-")[INDEX_FROM_YEAR_IN_UKRAINE]))
                > MIN_REQUIRED_YEARS_IN_UKRAINE);
    }
}
