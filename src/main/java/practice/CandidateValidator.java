package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {

    private static final int MIN_AGE = 35;
    private static final String NATIONALITY_UKRAINIAN = "Ukrainian";
    private static final int REQUIRED_LIVING_YEARS = 10;
    private static final String PERIOD_DELIMITER = "-";
    private static final int EXPECTED_PERIOD_PARTS = 2;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && NATIONALITY_UKRAINIAN.equalsIgnoreCase(candidate.getNationality())
                && checkTimeLivingInCountry(candidate.getPeriodsInUkr());
    }

    private boolean checkTimeLivingInCountry(String periodsInUkr) {
        String[] years = periodsInUkr.split(PERIOD_DELIMITER);
        if (years.length != EXPECTED_PERIOD_PARTS) {
            return false;
        }
        try {
            int startYear = Integer.parseInt(years[0]);
            int endYear = Integer.parseInt(years[1]);
            return (endYear - startYear) >= REQUIRED_LIVING_YEARS;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
