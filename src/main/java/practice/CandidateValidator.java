package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_CANDIDATE_AGE = 35;
    private static final int MIN_PERIOD_IN_UKR = 10;
    private static final String NATIONALITY = "Ukrainian";
    private static final String SEPARATOR_HYPHEN = "-";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_CANDIDATE_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && hasTenYearsInUkraine(candidate.getPeriodsInUkr());
    }

    private boolean hasTenYearsInUkraine(String periodsInUkr) {
        String[] years = periodsInUkr.split(SEPARATOR_HYPHEN);
        if (years.length != 2) {
            return false;
        }
        try {
            int startYear = Integer.parseInt(years[0]);
            int endYear = Integer.parseInt(years[1]);
            return (endYear - startYear) >= MIN_PERIOD_IN_UKR;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
