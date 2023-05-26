package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int AGE_ALLOWED_TO_VOTE = 35;
    private static final int ENOUGH_YEARS_LIVE_IN_COUNTRY = 10;
    private static final String NATIONALITY = "Ukrainian";
    private static final String DATE_SEPARATOR = "-";
    private static final int LIVE_IN_COUNTRY_FROM = 0;
    private static final int LIVE_IN_COUNTRY_TO = 1;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= AGE_ALLOWED_TO_VOTE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && enoughYearsLiveInUkraine(candidate.getPeriodsInUkr());
    }

    private boolean enoughYearsLiveInUkraine(String periodsInUkr) {
        String[] splitedPeriods = periodsInUkr.split(DATE_SEPARATOR);
        int years = Integer.parseInt(splitedPeriods[LIVE_IN_COUNTRY_TO])
                - Integer.parseInt(splitedPeriods[LIVE_IN_COUNTRY_FROM]);
        return years >= ENOUGH_YEARS_LIVE_IN_COUNTRY;
    }
}
