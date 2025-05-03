package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String REQUIRED_NATIONALITY = "Ukrainian";
    private static final int MIN_AGE = 35;
    private static final int REQUIRED_YEARS_IN_UKRAINE = 10;
    private static final String PERIODS_SEPARATOR = ",";
    private static final String YEAR_RANGE_SEPARATOR = "-";

    @Override
    public boolean test(Candidate candidate) {
        if (candidate.getAge() < MIN_AGE || !candidate.isAllowedToVote()
                || !REQUIRED_NATIONALITY.equals(candidate.getNationality())) {
            return false;
        }
        return livedInUkraineForTenYears(candidate.getPeriodsInUkr());
    }

    private boolean livedInUkraineForTenYears(String periodsInUkr) {
        String[] periods = periodsInUkr.split(PERIODS_SEPARATOR);
        int totalYears = 0;

        for (String period : periods) {
            String[] years = period.split(YEAR_RANGE_SEPARATOR);
            if (years.length == 2) {
                int startYear = Integer.parseInt(years[0].trim());
                int endYear = Integer.parseInt(years[1].trim());
                totalYears += endYear - startYear + 1;
            }
        }
        return totalYears >= REQUIRED_YEARS_IN_UKRAINE;
    }
}

