package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {

    private static final String YEAR_SEPARATOR = "-";
    private static final int START_YEAR_INDEX = 0;
    private static final int END_YEAR_INDEX = 1;
    private static final int VALID_CANDIDATE_AGE = 35;
    private static final String NATIONALITY = "Ukrainian";
    private static final int MIN_PERIOD_IN_UKRAINE = 10;

    @Override
    public boolean test(Candidate candidate) {
        String[] yearsInUkraine = candidate.getPeriodsInUkr().split(YEAR_SEPARATOR);
        int startYear = Integer.parseInt(yearsInUkraine[START_YEAR_INDEX]);
        int endYear = Integer.parseInt(yearsInUkraine[END_YEAR_INDEX]);
        return candidate.getAge() >= VALID_CANDIDATE_AGE
                && candidate.getNationality().equals(NATIONALITY)
                && candidate.isAllowedToVote()
                && (endYear - startYear) >= MIN_PERIOD_IN_UKRAINE;
    }
}
