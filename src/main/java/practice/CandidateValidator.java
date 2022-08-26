package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_ALLOWED_AGE = 35;
    private static final int MIN_YEARS_IN_UA = 10;
    private static final int FROM_YEAR_POSITION = 0;
    private static final int TO_YEAR_POSITION = 1;
    private static final String NATIONALITY = "Ukrainian";
    private static final String REGEX = "-";

    @Override
    public boolean test(Candidate candidate) {
        String[] yearsInUa = candidate.getPeriodsInUkr().split(REGEX);
        int firstYear = Integer.parseInt(yearsInUa[FROM_YEAR_POSITION]);
        int lastYear = Integer.parseInt(yearsInUa[TO_YEAR_POSITION]);
        return candidate.getAge() >= MIN_ALLOWED_AGE && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && lastYear - firstYear >= MIN_YEARS_IN_UA;
    }
}
