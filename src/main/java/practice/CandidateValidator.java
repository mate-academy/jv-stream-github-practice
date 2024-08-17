package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String SEPARATOR = "-";
    private static final String NATIONALITY = "Ukrainian";
    private static final int MIN_PERIOD = 10;
    private static final int MIN_AGE = 35;
    private static final int FROM_YEAR = 0;
    private static final int TO_YEAR = 1;

    @Override
    public boolean test(Candidate candidate) {
        String[] years = candidate.getPeriodsInUkr().split(SEPARATOR);
        int periodsInUkr = Integer.parseInt(years[TO_YEAR]) - Integer.parseInt(years[FROM_YEAR]);
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && periodsInUkr >= MIN_PERIOD;
    }
}
