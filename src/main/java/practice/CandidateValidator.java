package practice;

import model.Candidate;

import java.util.function.Predicate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String VALID_NATIONALITY = "Ukrainian";
    private static final String SEPARATOR = "-";
    private static final int MINIMUM_YEARS_IN_COUNTRY = 10;
    private static final int INDEX_OF_FIRST_YEAR = 0;
    private static final int INDEX_OF_LAST_YEAR = 1;
    private static final int VALID_AGE = 35;

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
        return calculatePeriodInCountry(candidate) >= MINIMUM_YEARS_IN_COUNTRY;
    }

    private int calculatePeriodInCountry(Candidate candidate) {
        String[] years = candidate.getPeriodsInUkr().split(SEPARATOR);
        return Integer.parseInt(years[INDEX_OF_LAST_YEAR])
                - Integer.parseInt(years[INDEX_OF_FIRST_YEAR]);
    }
}
