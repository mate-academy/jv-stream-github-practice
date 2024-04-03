package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_VALID_AGE = 35;
    private static final String NATIONALITY = "Ukrainian";
    private static final int MIN_VALID_LIVING_YEARS = 10;

    @Override
    public boolean test(Candidate candidate) {
        if (
                candidate.getAge() < MIN_VALID_AGE
                        || !candidate.getNationality().equals(NATIONALITY)
                        || !candidate.isAllowedToVote()
        ) {
            return false;
        }
        String[] yearsOfLife = candidate.getPeriodsInUkr().split("-");
        int startYear = Integer.parseInt(yearsOfLife[0]);
        int endYear = Integer.parseInt(yearsOfLife[1]);
        return (startYear <= endYear) && (endYear - startYear) >= MIN_VALID_LIVING_YEARS;
    }
}
