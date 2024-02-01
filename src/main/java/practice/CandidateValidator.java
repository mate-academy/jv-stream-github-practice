package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int VALID_CANDIDATE_AGE = 35;
    private static final int VALID_PERIOD_IN_UKR = 10;
    private static final String VALID_CANDIDATE_NATIONALITY = "Ukrainian";
    private static final String DIVIDER_FOR_INPUT_PERIOD = "-";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= VALID_CANDIDATE_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(VALID_CANDIDATE_NATIONALITY)
                && getIntPeriodInUkr(candidate.getPeriodsInUkr()) >= VALID_PERIOD_IN_UKR;
    }

    //Only for String type like: "2002-2015"
    private int getIntPeriodInUkr(String periodInUkr) {
        String[] period = periodInUkr.split(DIVIDER_FOR_INPUT_PERIOD);
        return Integer.parseInt(period[1]) - Integer.parseInt(period[0]);
    }
}
