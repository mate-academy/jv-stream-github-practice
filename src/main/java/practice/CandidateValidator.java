package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final String NATIONALITY = "Ukrainian";
    private static final int MIN_YEARS_IN_COUNTRY = 10;
    private static final String DASH = "-";
    private static final int INDEX_FROM = 0;
    private static final int INDEX_TO = 1;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE
                && candidate.getNationality().equals(NATIONALITY)
                && candidate.isAllowedToVote()
                && getYearsInUkraine(candidate.getPeriodsInUkr()) >= MIN_YEARS_IN_COUNTRY;
    }

    private int getYearsInUkraine(String periodsInUkr) {
        String[] years = periodsInUkr.split(DASH);
        return Integer.parseInt(years[INDEX_TO]) - Integer.parseInt(years[INDEX_FROM]);
    }
}
