package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE_OF_CANDIDATE = 35;
    private static final int START_OF_FIRST_YEAR_IN_PERIOD = 0;
    private static final int START_OF_SECOND_YEAR_IN_PERIOD = 5;
    private static final int MIN_STAY_IN_UKRAINE = 10;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE_OF_CANDIDATE
                && candidate.getNationality().equals("Ukrainian")
                && isValidPeriodInUkr(candidate.getPeriodsInUkr()) && candidate.isAllowedToVote();
    }

    private boolean isValidPeriodInUkr(String period) {
        int fromYear = Integer.parseInt(
                period.substring(START_OF_FIRST_YEAR_IN_PERIOD, period.indexOf("-")));
        int toYear = Integer.parseInt(period.substring(START_OF_SECOND_YEAR_IN_PERIOD));
        int yearsInUkraine = toYear - fromYear;
        return yearsInUkraine >= MIN_STAY_IN_UKRAINE;
    }
}
