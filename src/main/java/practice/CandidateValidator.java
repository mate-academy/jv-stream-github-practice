package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_YEARS_IN_UKR_REQUIREMENTS = 10;
    private static final int MIN_AGE = 35;

    @Override
    public boolean test(Candidate candidate) {
        String[] periodInUkraine = candidate.getPeriodsInUkr().split("-");
        int yearInUkraine = Integer.parseInt(periodInUkraine[1])
                - Integer.parseInt(periodInUkraine[0]);
        return candidate.isAllowedToVote() && candidate.getAge() >= MIN_AGE
                && candidate.getNationality().equals("Ukrainian")
                && yearInUkraine >= MIN_YEARS_IN_UKR_REQUIREMENTS;
    }
}
