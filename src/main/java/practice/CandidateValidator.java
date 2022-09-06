package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int MIN_PERIOD_IN_COUNTRY = 10;
    private static final int IN_COUNTRY_FROM_INDEX = 0;
    private static final int IN_COUNTRY_TO_INDEX = 1;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && REQUIRED_NATIONALITY.equals(candidate.getNationality())
                && getPeriodLiveInUkraine(candidate.getPeriodsInUkr()) >= MIN_PERIOD_IN_COUNTRY;
    }

    private int getPeriodLiveInUkraine(String periodsInUkr) {
        String[] period = periodsInUkr.split("-");
        return Integer.parseInt(period[IN_COUNTRY_TO_INDEX])
                - Integer.parseInt(period[IN_COUNTRY_FROM_INDEX]);
    }
}
