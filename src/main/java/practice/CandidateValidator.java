package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String PERIODS_SEPARATOR = "-";
    private static final String REQUIRED_NATIONALITY = "Ukrainian";
    private static final int FROM_PERIOD_INDEX = 0;
    private static final int TO_PERIOD_INDEX = 1;
    private static final int REQUIRED_YEARS = 10;
    private static final int REQUIRED_AGE = 35;

    @Override
    public boolean test(Candidate candidate) {
        String[] separatedPeriods = candidate.getPeriodsInUkr().split(PERIODS_SEPARATOR);
        int from = Integer.parseInt(separatedPeriods[FROM_PERIOD_INDEX]);
        int to = Integer.parseInt(separatedPeriods[TO_PERIOD_INDEX]);

        return candidate.getAge() >= REQUIRED_AGE
                && candidate.getNationality().equals(REQUIRED_NATIONALITY)
                && to - from >= REQUIRED_YEARS
                && candidate.isAllowedToVote();
    }
}
