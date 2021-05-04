package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator<T extends Candidate> implements Predicate<T> {
    private static final String DELIMITER = "-";
    private static final String NATIONALITY = "Ukrainian";
    private static final int REQUIRED_AGE = 35;
    private static final int REQUIRED_YEARS_OF_LIVING_IN_COUNTRY = 10;

    @Override
    public boolean test(T candidate) {
        String[] yearsInUkraine = candidate.getPeriodsInUkr().split(DELIMITER);
        int years = Integer.parseInt(yearsInUkraine[1]) - Integer.parseInt(yearsInUkraine[0]);
        return candidate.getAge() >= REQUIRED_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && years >= REQUIRED_YEARS_OF_LIVING_IN_COUNTRY;
    }
}
