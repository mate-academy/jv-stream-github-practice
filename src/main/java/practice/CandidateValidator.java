package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String NATIONALITY = "Ukrainian";
    private static final int MIN_AGE = 35;
    private static final int MIN_PERIOD_IN_UKRAINE = 10;
    private static final int FROM = 0;
    private static final int TO = 1;
    private static final String YEAR_SPLITTER = "-";

    @Override
    public boolean test(Candidate candidate) {
        String [] years = candidate.getPeriodsInUkr().split(YEAR_SPLITTER);
        int periodsInUkr = Integer.parseInt(years[TO]) - Integer.parseInt(years[FROM]);
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && periodsInUkr >= MIN_PERIOD_IN_UKRAINE;
    }
}
