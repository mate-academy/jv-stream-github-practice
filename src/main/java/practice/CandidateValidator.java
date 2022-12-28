package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int ALLOWED_AGE = 35;
    private static final String BEST_NATIONALITY_IN_WORLD = "Ukrainian";
    private static final int LIVES_IN_UKRAINE_TO_INDEX = 1;
    private static final int LIVES_IN_UKRAINE_FROM_INDEX = 0;
    private static final int REGUIREMENT_PERIOD = 10;

    @Override
    public boolean test(Candidate candidate) {
        String[] period = candidate.getPeriodsInUkr().split("-");
        int yearsLivesInUkraine = Integer.parseInt(period[LIVES_IN_UKRAINE_TO_INDEX])
                - Integer.parseInt(period[LIVES_IN_UKRAINE_FROM_INDEX]);
        return candidate.getAge() >= ALLOWED_AGE && candidate.isAllowedToVote()
                && candidate.getNationality().equals(BEST_NATIONALITY_IN_WORLD)
                && yearsLivesInUkraine >= REGUIREMENT_PERIOD;
    }
    //write your code here
}
