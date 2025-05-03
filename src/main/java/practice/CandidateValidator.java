package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    public static final String NATIONALITY = "Ukrainian";
    public static final int MIN_AGE = 35;
    public static final String SEPARATOR_HYPHEN = "-";
    public static final int MIN_YEAR_IN_COUNTRY = 10;
    public static final int INDEX_OF_FIRST_YEAR = 0;
    public static final int INDEX_OF_LAST_YEAR = 1;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && checkPeriodInUkraine(candidate.getPeriodsInUkr());
    }

    private boolean checkPeriodInUkraine(String date) {
        String[] dates = date.split(SEPARATOR_HYPHEN);
        int calculateYear = Integer.parseInt(dates[INDEX_OF_LAST_YEAR])
                - Integer.parseInt(dates[INDEX_OF_FIRST_YEAR]);
        return calculateYear > MIN_YEAR_IN_COUNTRY;
    }
}
