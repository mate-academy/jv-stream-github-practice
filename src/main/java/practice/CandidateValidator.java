package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_PERIOD_IN_UKRAINE = 10;
    private static final int START_PERIOD_INDEX = 0;
    private static final int END_PERIOD_INDEX = 1;
    private static final String CITIZENSHIP = "Ukrainian";
    private static final int MIN_AGE = 35;

    public boolean test(Candidate candidate) {
        String[] periods = candidate.getPeriodsInUkr().split("-");
        int periodsInUkraine = Integer.parseInt(periods[END_PERIOD_INDEX])
                - Integer.parseInt(periods[START_PERIOD_INDEX]);
        return candidate.getAge() >= MIN_AGE
                && candidate.getNationality().equals(CITIZENSHIP)
                && periodsInUkraine >= MIN_PERIOD_IN_UKRAINE
                && candidate.isAllowedToVote();
    }
}
