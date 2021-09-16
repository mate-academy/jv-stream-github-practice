package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String NATIONALITY = "Ukrainian";
    private static final int MIN_AGE = 35;
    private static final int LIVE_IN_UKRAINE = 10;
    private static final int INDEX_PERIOD_FIELD_FROM = 0;
    private static final int INDEX_PERIOD_FIELD_TO = 1;

    @Override
    public boolean test(Candidate candidate) {
        int yearFrom = Integer.parseInt(candidate.getPeriodsInUkr()
                .split("-")[INDEX_PERIOD_FIELD_FROM]);
        int yearTo = Integer.parseInt(candidate.getPeriodsInUkr()
                .split("-")[INDEX_PERIOD_FIELD_TO]);
        return candidate.getNationality().equals(NATIONALITY)
                && candidate.getAge() >= MIN_AGE
                && (yearTo - yearFrom) >= LIVE_IN_UKRAINE
                && candidate.isAllowedToVote();
    }
}
