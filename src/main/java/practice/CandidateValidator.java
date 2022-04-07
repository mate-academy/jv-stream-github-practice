package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MINIMUM_AGE = 35;
    private static final int NEEDED_YEARS_IN_UKRAINE = 10;

    @Override
    public boolean test(Candidate candidate) {

        String[] period = candidate.getPeriodsInUkr().split("-");
        Integer periodStar = Integer.parseInt(period[0]);
        Integer periodFinish = Integer.parseInt(period[1]);
        return candidate.getAge() >= MINIMUM_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals("Ukrainian")
                && periodFinish - periodStar >= NEEDED_YEARS_IN_UKRAINE;
    }
}
