package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_CANDIDATE_AGE = 35;
    private static final int MIN_PERIOD_IN_UKRAINE = 10;

    @Override
    public boolean test(Candidate candidate) {
        if (candidate.isAllowedToVote()
                && candidate.getAge() >= MIN_CANDIDATE_AGE
                && candidate.getNationality().equals("Ukrainian")) {
            int startYear = Integer.parseInt(
                    candidate.getPeriodsInUkr().split("-")[0]);
            int endYear = Integer.parseInt(
                    candidate.getPeriodsInUkr().split("-")[1]);
            return endYear - startYear >= MIN_PERIOD_IN_UKRAINE;
        }
        return false;
    }
}
