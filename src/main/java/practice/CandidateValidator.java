package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    public static final int MIN_AGE = 35;
    public static final boolean IS_ELIGIBLE_TO_VOTE = true;
    public static final String NATIONALITY = "Ukrainian";
    public static final int MIN_YEARS_IN_COUNTRY = 10;
    public static final String DASH = "-";
    public static final int INDEX_FROM = 0;
    public static final int INDEX_TO = 1;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE
                && candidate.getNationality().equals(NATIONALITY)
                && candidate.isAllowedToVote() == IS_ELIGIBLE_TO_VOTE
                && getYearsInUkraine(candidate.getPeriodsInUkr()) >= MIN_YEARS_IN_COUNTRY;
    }

    private int getYearsInUkraine(String periodsInUkr) {
        String[] years = periodsInUkr.split(DASH);
        return Integer.parseInt(years[INDEX_TO]) - Integer.parseInt(years[INDEX_FROM]);
    }
}
