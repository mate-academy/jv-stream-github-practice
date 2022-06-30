package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MINIMUM_AGE = 35;
    private static final int MINIMUM_YEARS = 10;
    private static final int INDEX_START_PERIOD = 0;
    private static final int INDEX_END_PERIOD = 1;
    private static final String NATIONALITY = "Ukrainian";
    private static final String YEARS_SEPARATOR = "-";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.isAllowedToVote()
                && checkYears(candidate.getAge())
                && checkNationality(candidate.getNationality())
                && checkPeriodInUkraine(candidate.getPeriodsInUkr());
    }

    private boolean checkYears(int year) {
        return year >= MINIMUM_AGE;
    }

    private boolean checkNationality(String nationality) {
        return NATIONALITY.equals(nationality);
    }

    private boolean checkPeriodInUkraine(String period) {
        String[] years = period.split(YEARS_SEPARATOR);
        int fromYear = Integer.parseInt(years[INDEX_START_PERIOD]);
        int toYear = Integer.parseInt(years[INDEX_END_PERIOD]);
        return toYear - fromYear >= MINIMUM_YEARS;
    }
}
