package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String REQUIRED_NATIONALITY = "Ukrainian";
    private static final int REQUIRED_PERIOD_IN_COUNTRY = 10;
    private static final int MIN_AGE_REQUIRED = 35;
    private static final int PERIOD_START_INDEX = 0;
    private static final int PERIOD_END_INDEX = 1;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getNationality().equals(REQUIRED_NATIONALITY)
                && candidate.getAge() >= MIN_AGE_REQUIRED
                && candidate.isAllowedToVote()
                && chkPeriodsInUkraine(candidate);
    }

    private static boolean chkPeriodsInUkraine(Candidate candidate) {
        String[] period = candidate.getPeriodsInUkr().split("-");
        return (Integer.parseInt(period[PERIOD_END_INDEX])
                - Integer.parseInt(period[PERIOD_START_INDEX])) >= REQUIRED_PERIOD_IN_COUNTRY;

    }
}
