package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int AGE_LIMIT = 35;
    private static final int REQUIRED_YEARS_IN_UKRAINE = 10;
    private static final int INDEX_AGE_FROM = 0;
    private static final int INDEX_AGE_TO = 1;
    private static final String NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.isAllowedToVote()
                && candidate.getAge() >= AGE_LIMIT
                && candidate.getNationality().equals(NATIONALITY)
                && hasLivedInUkraineLongEnough(candidate.getPeriodsInUkr());
    }

    private boolean hasLivedInUkraineLongEnough(String periodsInUkr) {
        String[] periods = periodsInUkr.split("-");

        return (Integer.parseInt(periods[INDEX_AGE_TO])
                - Integer.parseInt(periods[INDEX_AGE_FROM])) >= REQUIRED_YEARS_IN_UKRAINE;
    }
}
