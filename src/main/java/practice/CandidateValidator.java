package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MINIMUM_AGE = 35;
    private static final int MINIMUM_YEARS_IN_UKRAINE = 10;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";
    private static final String YEAR_SEPARATOR = "-";
    private static final int START_YEAR_INDEX = 0;
    private static final int END_YEAR_INDEX = 1;

    @Override
    public boolean test(Candidate candidate) {
        int age = candidate.getAge();
        boolean allowedToVote = candidate.isAllowedToVote();
        String nationality = candidate.getNationality();
        String periodsInUkr = candidate.getPeriodsInUkr();
        return age >= MINIMUM_AGE && allowedToVote
                && REQUIRED_NATIONALITY.equals(nationality)
                && hasLivedInUkraineFor10Years(periodsInUkr);
    }

    private boolean hasLivedInUkraineFor10Years(String periodsInUkraine) {
        String[] startYearAndEndYear = periodsInUkraine.split(YEAR_SEPARATOR);
        int yearsInUkraine = Integer.parseInt(startYearAndEndYear[END_YEAR_INDEX])
                - Integer.parseInt(startYearAndEndYear[START_YEAR_INDEX]);
        return yearsInUkraine >= MINIMUM_YEARS_IN_UKRAINE;
    }
}
