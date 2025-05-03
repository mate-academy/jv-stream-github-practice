package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int VALID_AGE = 35;
    private static final int INDEX_PERIOD_FROM = 0;
    private static final int INDEX_PERIOD_TO = 1;
    private static final int VALID_PERIOD = 10;
    private static final String VALID_NATIONALITY = "Ukrainian";
    private static final String DATE_SEPARATOR = "-";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= VALID_AGE
                 && candidate.getNationality().equals(VALID_NATIONALITY)
                 && candidate.isAllowedToVote()
                 && validPeriod(candidate);
    }

    private boolean validPeriod(Candidate candidate) {
        String[] dates = candidate.getPeriodsInUkr().split(DATE_SEPARATOR);
        int start = Integer.parseInt(dates[INDEX_PERIOD_FROM]);
        int finish = Integer.parseInt(dates[INDEX_PERIOD_TO]);
        return (finish - start) >= VALID_PERIOD;
    }
}
