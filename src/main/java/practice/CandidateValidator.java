package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int MIN_PERIOD_IN_UKR = 10;

    @Override
    public boolean test(Candidate candidate) {
        int yearFrom = Integer.parseInt(candidate
                .getPeriodsInUkr()
                .substring(0, candidate.getPeriodsInUkr().indexOf("-")));
        int yearTo = Integer.parseInt(candidate.getPeriodsInUkr()
                .substring(candidate.getPeriodsInUkr().indexOf("-") + 1));
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals("Ukrainian")
                && yearTo - yearFrom >= MIN_PERIOD_IN_UKR;
    }
}
