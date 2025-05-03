package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final String COUNTRY = "Ukrainian";
    private static final int MIN_LIVE_IN_COUNTRY = 10;
    private static final String YEARS_SEPARATOR = "-";
    private static final int PERIOD_YEAR_FROM = 0;
    private static final int PERIOD_YEAR_TO = 1;

    @Override
    public boolean test(Candidate candidate) {
        String[] period = candidate.getPeriodsInUkr().split(YEARS_SEPARATOR);
        int yearFrom = Integer.parseInt(period[PERIOD_YEAR_FROM]);
        int yearTo = Integer.parseInt(period[PERIOD_YEAR_TO]);

        return candidate.getAge() >= MIN_AGE && candidate.isAllowedToVote()
                && COUNTRY.equals(candidate.getNationality())
                && (yearTo - yearFrom) > MIN_LIVE_IN_COUNTRY;
    }
}
