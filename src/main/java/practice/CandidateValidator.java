package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MINIMUM_YEARS = 35;
    private static final int MINIMUM_PERIOD_IN_UKRAINE = 10;
    private static final int INDEX_START_PERIOD_IN_UKRAINE = 0;
    private static final int INDEX_END_PERIOD_IN_UKRAINE = 1;
    private static final String UKRAINE_NATIONALITY = "Ukrainian";
    private static final String YEARS_SEPARATOR = "-";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.isAllowedToVote()
                && checkYears(candidate.getAge())
                && checkNationality(candidate.getNationality())
                && checkPeriodInUkraine(candidate.getPeriodsInUkr());
    }

    private boolean checkYears(int year) {
        return year >= MINIMUM_YEARS;
    }

    private boolean checkNationality(String nationality) {
        return UKRAINE_NATIONALITY.equals(nationality);
    }

    private boolean checkPeriodInUkraine(String period) {
        String[] years = period.split(YEARS_SEPARATOR);
        int fromYear = Integer.parseInt(years[INDEX_START_PERIOD_IN_UKRAINE]);
        int toYear = Integer.parseInt(years[INDEX_END_PERIOD_IN_UKRAINE]);
        return toYear - fromYear >= MINIMUM_PERIOD_IN_UKRAINE;
    }
}
