package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int VALID_AGE = 35;
    private static final String VALID_NATIONALITY = "Ukrainian";
    private static final int INDEX_OF_FIRST_YEAR = 0;
    private static final int INDEX_OF_LAST_YEAR = 1;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.isAllowedToVote()
                && isValidAge(candidate)
                && isValidNationality(candidate)
                && isValidPeriodInUkr(candidate);
    }

    private boolean isValidAge(Candidate candidate) {
        return candidate.getAge() >= VALID_AGE;
    }

    private boolean isValidNationality(Candidate candidate) {
        return candidate.getNationality().equals(VALID_NATIONALITY);
    }

    private boolean isValidPeriodInUkr(Candidate candidate) {
        return calculatePeriodInCountry(candidate) >= 10;
    }

    private int calculatePeriodInCountry(Candidate candidate) {
        String[] arr = candidate.getPeriodsInUkr().split("-");
        return Integer.parseInt(arr[INDEX_OF_LAST_YEAR])
                - Integer.parseInt(arr[INDEX_OF_FIRST_YEAR]);
    }
}
