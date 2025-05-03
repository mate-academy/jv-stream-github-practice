package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_VALID_AGE = 35;
    private static final int MIN_VALID_YEARS_LIVED_IN_UKRAINE = 10;
    private static final int FIRST_YEAR_IN_LIVE_PERIOD_INDEX = 0;
    private static final int SECOND_YEAR_IN_LIVE_PERIOD_INDEX = 1;

    @Override
    public boolean test(Candidate candidate) {
        String[] liveYears = candidate.getPeriodsInUkr().split("-");
        return candidate.getAge() >= MIN_VALID_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals("Ukrainian")
                && Integer.parseInt(liveYears[SECOND_YEAR_IN_LIVE_PERIOD_INDEX])
                - Integer.parseInt(liveYears[FIRST_YEAR_IN_LIVE_PERIOD_INDEX])
                > MIN_VALID_YEARS_LIVED_IN_UKRAINE;
    }
}
