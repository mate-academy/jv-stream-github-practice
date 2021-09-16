package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate {
    private static final int MINIMUM_CANDIDATE_AGE = 35;
    private static final int MINIMUM_PERIOD_IN_UKRAINE = 10;

    @Override
    public boolean test(Object c) {
        Candidate candidate = (Candidate) c;
        String[] split = candidate.getPeriodsInUkr().split("-");
        int difference = Math.abs(Integer.parseInt(split[0]) - Integer.parseInt(split[1]));
        boolean validPerionInUkraine = difference > MINIMUM_PERIOD_IN_UKRAINE;
        return candidate.isAllowedToVote()
                && candidate.getNationality().equals("Ukrainian")
                && candidate.getAge() >= MINIMUM_CANDIDATE_AGE
                && validPerionInUkraine;
    }
}
