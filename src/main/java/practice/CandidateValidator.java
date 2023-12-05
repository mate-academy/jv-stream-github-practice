package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE_TO_VOTE = 35;
    private static final int MIN_YEARS_IN_UKRAINE = 10;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE_TO_VOTE
                && candidate.isAllowedToVote()
                && "Ukrainian".equals(candidate.getNationality())
                && livedInUkraineForAtLeastTenYears(candidate.getPeriodsInUkr());
    }

    private boolean livedInUkraineForAtLeastTenYears(String periodsInUkr) {
        String[] years = periodsInUkr.split("-");
        if (years.length != 2) {
            return false;
        }

        try {
            int startYear = Integer.parseInt(years[0]);
            int endYear = Integer.parseInt(years[1]);
            return (endYear - startYear) >= MIN_YEARS_IN_UKRAINE;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
