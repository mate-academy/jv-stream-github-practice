package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_ALLOWED_AGE = 35;
    private static final String NATIONALITY = "Ukrainian";
    private static final int MIN_YEARS_IN_UA = 10;

    @Override
    public boolean test(Candidate candidate) {
        String[] yearsInUa = candidate.getPeriodsInUkr().split("-");
        int firstYear = Integer.parseInt(yearsInUa[0]);
        int lastYear = Integer.parseInt(yearsInUa[1]);

        return candidate.getAge() >= MIN_ALLOWED_AGE && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && lastYear - firstYear >= MIN_YEARS_IN_UA;
    }
}
