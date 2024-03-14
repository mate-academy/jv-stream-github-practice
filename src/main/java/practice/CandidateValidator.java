package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String CANDIDATE_NATIONALITY = "Ukrainian";
    private static final String DIVIDER = "-";
    private static final int MIN_CANDIDATE_AGE = 35;

    private static final int MIN_YEARS_IN_UKRAINE = 10;
    private static final int FIRST_YEAR_INDEX_IN_PERIOD = 0;
    private static final int LAST_YEAR_INDEX_IN_PERIOD = 1;

    @Override
    public boolean test(Candidate candidate) {
        String[] periods = candidate.getPeriodsInUkr().split(DIVIDER);
        int firstYear = Integer.parseInt(periods[FIRST_YEAR_INDEX_IN_PERIOD]);
        int lastYear = Integer.parseInt(periods[LAST_YEAR_INDEX_IN_PERIOD]);
        int totalYears = Math.abs(firstYear - lastYear);
        return candidate.getNationality().equals(CANDIDATE_NATIONALITY)
                && candidate.getAge() >= MIN_CANDIDATE_AGE
                && candidate.isAllowedToVote()
                && totalYears >= MIN_YEARS_IN_UKRAINE;
    }
}
