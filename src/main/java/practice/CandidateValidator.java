package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String NATIONALITY = "Ukrainian";
    private static final String HYPHEN = "-";
    private static final int YEAR_FROM_INDEX = 0;
    private static final int YEAR_UNTIL_INDEX = 1;
    private static final int MIN_AGE = 35;
    private static final int MIN_YEARS_IN_UKRAINE = 10;

    @Override
    public boolean test(Candidate candidate) {
        String[] years = candidate.getPeriodsInUkr().split(HYPHEN);
        int yearsInUkraine = Integer.parseInt(years[YEAR_UNTIL_INDEX])
                - Integer.parseInt(years[YEAR_FROM_INDEX]);
        return candidate.getAge() >= MIN_AGE && candidate.isAllowedToVote()
                && NATIONALITY.equals(candidate.getNationality())
                && yearsInUkraine >= MIN_YEARS_IN_UKRAINE;
    }
}
