package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String ALLOWED_NATIONALITY = "Ukrainian";
    private static final String YEAR_SPLIT_REGEX = "-";
    private static final int ALLOWED_AGE = 35;
    private static final int MIN_UKR_LIVING_YEARS = 10;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.isAllowedToVote()
                && candidate.getAge() >= ALLOWED_AGE
                && candidate.getNationality().equals(ALLOWED_NATIONALITY)
                && getPeriodDifference(candidate.getPeriodsInUkr()) >= MIN_UKR_LIVING_YEARS;
    }

    private int getPeriodDifference(String periodsInUkr) {
        int fromYear = Integer.parseInt(
                periodsInUkr.substring(0, periodsInUkr.indexOf(YEAR_SPLIT_REGEX)));
        int tillYear = Integer.parseInt(
                periodsInUkr.substring(periodsInUkr.indexOf(YEAR_SPLIT_REGEX) + 1));
        return tillYear - fromYear;
    }
}
