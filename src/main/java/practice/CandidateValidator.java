package practice;

import model.Candidate;

public class CandidateValidator {
    private static final double MIN_AGE = 35;
    private static final int MIN_PERIOD_IN_UKR = 10;
    private static final String NATIONALITY = "Ukrainian";
    private static final String YEAR_SEPARATOR = "-";
    private static final int FROM_YEAR = 0;
    private static final int TO_YEAR = 1;

    public boolean isValidCandidate(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && getYearsInUkr(candidate.getPeriodsInUkr()) >= MIN_PERIOD_IN_UKR;
    }

    private static int getYearsInUkr(String candidate) {
        String[] years = candidate.split(YEAR_SEPARATOR);
        return Integer.parseInt(years[TO_YEAR]) - Integer.parseInt(years[FROM_YEAR]);
    }
}
