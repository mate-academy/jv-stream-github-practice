package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";
    private static final int MIN_PERIOD_IN_UKRAINE = 10;
    private static final int INDEX_YEAR_FROM = 0;
    private static final int INDEX_YEAR_TO = 1;

    @Override
    public boolean test(Candidate candidate) {
        int yearTo = Integer.parseInt(candidate.getPeriodsInUkr().split("-")[INDEX_YEAR_TO]);
        int yearFrom = Integer.parseInt(candidate.getPeriodsInUkr().split("-")[INDEX_YEAR_FROM]);
        return candidate.getAge() >= MIN_AGE
                && candidate.getNationality().equals(REQUIRED_NATIONALITY)
                && candidate.isAllowedToVote()
                && yearTo - yearFrom
                >= MIN_PERIOD_IN_UKRAINE;
    }
}
