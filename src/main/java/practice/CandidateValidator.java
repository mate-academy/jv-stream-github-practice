package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    //write your code here
    private static final int AGE_FROM = 35;
    private static final String NATIONALITY = "Ukrainian";
    private static final String CHAR_FOR_SPLIT = "-";
    private static final int PERIOD_IN_UKRAINE = 10;

    @Override
    public boolean test(Candidate candidate) {
        if (candidate.getAge() >= AGE_FROM
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)) {
            String[] splitedPeriod = candidate.getPeriodsInUkr().split(CHAR_FOR_SPLIT);
            int period = Integer.parseInt(splitedPeriod[1])
                    - Integer.parseInt(splitedPeriod[0]);
            return period >= PERIOD_IN_UKRAINE;
        }
        return false;
    }
}
