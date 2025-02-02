package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int FROM_AGE = 35;
    private static final int PERIOD_IN_UKRAINE = 10;
    @Override
    public boolean test(Candidate candidate) {
        String[] split = candidate.getPeriodsInUkr().split("-");
        int startYear = Integer.parseInt(split[0]);
        int endYear = Integer.parseInt(split[1]);
        int result = endYear - startYear;
        return candidate.getAge() >= FROM_AGE && candidate.isAllowedToVote()
                && candidate.getNationality().equals("Ukrainian")
                && result >= PERIOD_IN_UKRAINE;
    }
}
