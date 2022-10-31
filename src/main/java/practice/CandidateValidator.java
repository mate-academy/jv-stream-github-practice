package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String REQUIRED_NATIONALITY = "Ukrainian";
    private static final String SEPARATOR = "-";
    private static final int MIN_VALID_AGE = 35;
    private static final int MIN_YEARS_IN_UKRAINE = 10;
    private static final int DATE_TO_INDEX = 1;
    private static final int DATE_FROM_INDEX = 0;

    @Override
    public boolean test(Candidate candidate) {
        String[] yearsInUkraine = candidate.getPeriodsInUkr().split(SEPARATOR);
        return candidate.getAge() >= MIN_VALID_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(REQUIRED_NATIONALITY)
                && (Integer.parseInt(yearsInUkraine[DATE_TO_INDEX])
                - Integer.parseInt(yearsInUkraine[DATE_FROM_INDEX]))
                >= MIN_YEARS_IN_UKRAINE;
    }
}
