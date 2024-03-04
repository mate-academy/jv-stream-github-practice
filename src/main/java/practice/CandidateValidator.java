package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int ALLOWED_AGE = 35;
    private static final int NUMBER_OF_YEARS_IN_UKRAINE = 10;
    private static final int FROM_YEAR_INDEX = 0;
    private static final int TO_YEAR_INDEX = 1;
    private static final String SEPARATOR = "-";

    @Override
    public boolean test(Candidate candidate) {
        String[] yearsInUkraine = candidate.getPeriodsInUkr().split(SEPARATOR);
        int fromYear = Integer.parseInt(yearsInUkraine[FROM_YEAR_INDEX]);
        int toYear = Integer.parseInt(yearsInUkraine[TO_YEAR_INDEX]);

        return candidate.getAge() >= ALLOWED_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals("Ukrainian")
                && toYear - fromYear >= NUMBER_OF_YEARS_IN_UKRAINE;
    }
}
