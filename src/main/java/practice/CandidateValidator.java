package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int AGE_ALLOWED_TO_VOTE = 35;
    private static final int ENOUGH_YEARS_LIVE_IN_COUNTRY = 10;
    private static final String COUNTRY_OF_ELECTION = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getClass().equals(Candidate.class)
                && candidate.getAge() >= AGE_ALLOWED_TO_VOTE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(COUNTRY_OF_ELECTION)
                && enoughYearsLiveInUkraine(candidate.getPeriodsInUkr());
    }

    private boolean enoughYearsLiveInUkraine(String periodsInUkr) {
        String[] splitedPeriods = periodsInUkr.split("-");
        int result = Integer.parseInt(splitedPeriods[1]) - Integer.parseInt(splitedPeriods[0]);
        return result >= ENOUGH_YEARS_LIVE_IN_COUNTRY;
    }
}
