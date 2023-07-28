package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int ZERO = 0;
    private static final int FOUR = 4;
    private static final int CANDIDATE_VALID_AGE = 35;
    private static final int SUFFICIENT_YEARS_LIVED_IN_UKRAINE = 10;
    private static final String VALID_NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        String yearFrom = candidate
                .getPeriodsInUkr()
                .substring(ZERO, FOUR);
        String yearUntil = candidate
                .getPeriodsInUkr()
                .substring(candidate.getPeriodsInUkr().length() - FOUR);
        return candidate.getAge() >= CANDIDATE_VALID_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(VALID_NATIONALITY)
                && Integer.parseInt(yearUntil) - Integer.parseInt(yearFrom)
                > SUFFICIENT_YEARS_LIVED_IN_UKRAINE;
    }
}
