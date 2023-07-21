package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE_PRESIDENT = 35;
    private static final String NATIONALITY = "Ukrainian";
    private static final int MIN_PERIOD_LIVE_IN_UKRAINE = 10;
    private static final int LIVED_IN_UKRAINE_TO_INDEX = 1;
    private static final int LIVED_IN_UKRAINE_SINCE_INDEX = 0;

    @Override
    public boolean test(Candidate candidate) {
        String[] year = candidate.getPeriodsInUkr().split("-");
        int periodInUkraine = Integer.parseInt(year[LIVED_IN_UKRAINE_TO_INDEX])
                - Integer.parseInt(year[LIVED_IN_UKRAINE_SINCE_INDEX]);
        return candidate.getAge() >= MIN_AGE_PRESIDENT
                && candidate.getNationality().equals(NATIONALITY)
                && candidate.isAllowedToVote()
                && periodInUkraine >= MIN_PERIOD_LIVE_IN_UKRAINE;
    }
}
