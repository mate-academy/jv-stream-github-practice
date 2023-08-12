package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int PERIOD_IN_UKRAINE = 10;
    //write your code here

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= 35 && candidate.isAllowedToVote()
                && candidate.getNationality().equals("Ukrainian")
                && periodsInUkrBool(candidate);
    }

    private boolean periodsInUkrBool(Candidate candidate) {
        String[] split = candidate.getPeriodsInUkr().split("-");
        int i = Integer.parseInt(split[1]) - Integer.parseInt(split[0]);
        return i >= PERIOD_IN_UKRAINE;
    }
}
