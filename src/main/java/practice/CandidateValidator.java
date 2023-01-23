package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int MIN_PERIOD_IN_UKRAINE = 10;
    private static final int PERIOD_FROM = 0;
    private static final int PERIOD_TO = 1;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        String[] years = candidate.getPeriodsInUkr().split("-");
        int periodInUkraine = Integer.parseInt(years[PERIOD_TO])
                - Integer.parseInt(years[PERIOD_FROM]);
        return candidate.getAge() >= MIN_AGE && candidate.isAllowedToVote()
                && candidate.getNationality().equals(REQUIRED_NATIONALITY)
                && periodInUkraine >= MIN_PERIOD_IN_UKRAINE;
    }
}
