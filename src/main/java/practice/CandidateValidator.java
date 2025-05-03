package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int FROM = 0;
    private static final int TO = 1;
    private static final int MIN_PERIOD = 10;
    private static final String NATIONALITY = "Ukrainian";
    private static final String DIVIDER = "-";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && getPeriod(candidate.getPeriodsInUkr()) >= MIN_PERIOD;
    }

    private int getPeriod(String period) {
        String[] years = period.split(DIVIDER);
        return Integer.parseInt(years[TO]) - Integer.parseInt(years[FROM]);
    }
}
