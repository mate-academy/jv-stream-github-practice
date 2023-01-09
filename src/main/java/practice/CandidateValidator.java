package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int YEARS_IN_UKRAINE = 10;
    private static final int INDEX_YEARS_FROM = 0;
    private static final int INDEX_YEARS_TO = 1;

    @Override
    public boolean test(Candidate candidate) {
        String[] yearsInUkraine = candidate.getPeriodsInUkr().split("-");
        int intYearsFrom = Integer.parseInt(yearsInUkraine[INDEX_YEARS_FROM]);
        int intYearsTo = Integer.parseInt(yearsInUkraine[INDEX_YEARS_TO]);
        int intYearsInUkraine = intYearsTo - intYearsFrom;
        return candidate.getAge() >= MIN_AGE && candidate.isAllowedToVote()
                && candidate.getNationality().equals("Ukrainian")
                && intYearsInUkraine >= YEARS_IN_UKRAINE;
    }
}
