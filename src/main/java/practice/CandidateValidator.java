package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final String NATIONALITY = "Ukrainian";
    private static final int MIN_PERIOD_IN_UKRAINE = 10;
    private static final String REGEX = "-";
    private static final int TO_YEAR_LIVING = 1;
    private static final int FROM_YEAR_LIVING = 0;

    @Override
    public boolean test(Candidate candidate) {
        String[] years = candidate.getPeriodsInUkr().split(REGEX);
        int period = Integer.parseInt(years[TO_YEAR_LIVING])
                - Integer.parseInt(years[FROM_YEAR_LIVING]);
        return candidate.getAge() >= MIN_AGE
                && candidate.getNationality().equals(NATIONALITY)
                && candidate.isAllowedToVote()
                && period >= MIN_PERIOD_IN_UKRAINE;
    }
}
