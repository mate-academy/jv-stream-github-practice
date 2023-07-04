package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {

    public static final int MIN_AGE_FOR_VOTE = 35;
    public static final String MANDATORY_NATIONALITY = "Ukrainian";
    public static final int MIN_PERIOD_IN_UKR = 10;

    @Override
    public boolean test(Candidate candidate) {
        if (candidate.getAge() < MIN_AGE_FOR_VOTE) {
            return false;
        }
        if (!candidate.getNationality().equals(MANDATORY_NATIONALITY)) {
            return false;
        }
        if (!candidate.isAllowedToVote()) {
            return false;
        }
        return periodLifeInUkr(candidate.getPeriodsInUkr()) >= MIN_PERIOD_IN_UKR;
    }

    private static int periodLifeInUkr(String period) {
        if (period == null) {
            return 0;
        }
        String[] split = period.split("-");
        int startPeriod = Integer.parseInt(split[0]);
        int endPeriod = Integer.parseInt(split[1]);
        return endPeriod - startPeriod;

    }
    //write your code here
}
