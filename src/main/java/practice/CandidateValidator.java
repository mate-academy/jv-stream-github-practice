package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_PERIOD_ALLOWED = 10;

    @Override
    public boolean test(Candidate candidate) {
        String[] periodInUkraine = candidate.getPeriodsInUkr().split("-");
        int fromYear = Integer.parseInt(periodInUkraine[0]);
        int toYear = Integer.parseInt(periodInUkraine[1]);
        return candidate.getAge() >= 35
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals("Ukrainian")
                && toYear - fromYear >= MIN_PERIOD_ALLOWED;
    }
}
