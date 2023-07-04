package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MINIMUM_AGE = 35;
    private static final int MINIMUM_YEARS_IN_UKRAINE = 10;
    private static final int END_YEAR_INDEX = 1;
    private static final int START_YEAR_INDEX = 0;
    private static final String UKRAINIAN_NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MINIMUM_AGE
                && candidate.isAllowedToVote()
                && UKRAINIAN_NATIONALITY.equals(candidate.getNationality())
                && hasLivedInUkraineForTenYears(candidate.getPeriodsInUkr());
    }

    private boolean hasLivedInUkraineForTenYears(String periodsInUkr) {
        String[] periods = periodsInUkr.split("-");
        int startYear = Integer.parseInt(periods[START_YEAR_INDEX]);
        int endYear = Integer.parseInt(periods[END_YEAR_INDEX]);

        return endYear - startYear >= MINIMUM_YEARS_IN_UKRAINE;
    }
}
