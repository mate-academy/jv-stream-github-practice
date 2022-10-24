package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_YEARS_IN_UKRAINE = 10;
    private static final int MIN_AGE = 35;
    private static final String MINUS_SEPARATOR = "-";
    private static final int BY_YEAR_IDX = 1;
    private static final int FROM_YEAR_IDX = 0;
    private static final String NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        if (candidate.getAge() < MIN_AGE
                || !candidate.isAllowedToVote()
                || !candidate.getNationality().equals(NATIONALITY)) {
            return false;
        }
        String[] period = candidate.getPeriodsInUkr().split(MINUS_SEPARATOR);
        return Integer.parseInt(period[BY_YEAR_IDX])
                - Integer.parseInt(period[FROM_YEAR_IDX]) >= MIN_YEARS_IN_UKRAINE;
    }
}
