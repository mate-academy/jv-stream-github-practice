package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int CANDIDATE_AGE = 35;
    private static final String CANDIDATE_NATIONALITY = "Ukrainian";
    private static final int YEARS_LIVED_IN_COUNTRY = 10;
    private static final int FROM_YEAR_PERIOD_INDEX = 0;
    private static final int TO_YEAR_PERIOD_INDEX = 1;
    private static final String PERIOD_DELIMITER = "-";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= CANDIDATE_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(CANDIDATE_NATIONALITY)
                && getPeriodInUkraine(candidate.getPeriodsInUkr()) >= YEARS_LIVED_IN_COUNTRY;
    }

    private int getPeriodInUkraine(String period) {
        String[] years = period.split(PERIOD_DELIMITER);
        int firstYear = Integer.parseInt(years[FROM_YEAR_PERIOD_INDEX]);
        int lastYear = Integer.parseInt(years[TO_YEAR_PERIOD_INDEX]);
        return lastYear - firstYear;
    }
}
