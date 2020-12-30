package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int YEAR_FROM = 0;
    private static final int YEAR_TO = 1;
    private static final int MINIMUM_AGE = 35;
    private static final String NATIONALITY = "Ukrainian";
    private static final int MINIMUM_YEARS_IN_UKRAINE = 10;

    @Override
    public boolean test(Candidate candidate) {
        String[] yearsInUkraine = candidate.getPeriodsInUkr().split("-");
        int yearFrom = Integer.parseInt(yearsInUkraine[YEAR_FROM]);
        int yearTo = Integer.parseInt(yearsInUkraine[YEAR_TO]);
        return candidate.isAllowedToVote()
                && candidate.getAge() >= MINIMUM_AGE
                && candidate.getNationality().equals(NATIONALITY)
                && yearTo - yearFrom >= MINIMUM_YEARS_IN_UKRAINE;
    }
}
