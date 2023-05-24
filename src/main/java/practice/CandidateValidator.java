package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    public static final String NATIONALITY = "Ukrainian";
    public static final int MIN_AGE = 35;
    public static final String SEPARATOR_HYPHEN = "-";
    public static final int MIN_YEAR_IN_COUNTRY = 10;
    public static final int START_LIVING_IN_COUNTRY_INDEX = 0;
    public static final int LIVING_UNTIL_IN_COUNTRY_INDEX = 1;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && checkPeriodInUkraine(candidate.getPeriodsInUkr());
    }

    private boolean checkPeriodInUkraine(String date) {
        String[] dates = date.split(SEPARATOR_HYPHEN);
        int calculateYear = Integer.parseInt(dates[LIVING_UNTIL_IN_COUNTRY_INDEX])
                - Integer.parseInt(dates[START_LIVING_IN_COUNTRY_INDEX]);
        return calculateYear > MIN_YEAR_IN_COUNTRY;
    }
}
