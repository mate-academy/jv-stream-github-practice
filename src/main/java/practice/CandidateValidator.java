package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int CANDIDATE_MIN_AGE = 35;
    private static final int MIN_PERIOD_IN_UKRAINE = 10;

    @Override
    public boolean test(Candidate candidate) {
        int periodInUkrFrom = Integer.parseInt(candidate.getPeriodsInUkr().substring(0, 4));
        int periodInUkrTo = Integer.parseInt(candidate.getPeriodsInUkr().substring(5));
        int periodInUkr = periodInUkrTo - periodInUkrFrom;
        return candidate.getAge() >= CANDIDATE_MIN_AGE && candidate.isAllowedToVote()
                && candidate.getNationality().equals("Ukrainian")
                && periodInUkr >= MIN_PERIOD_IN_UKRAINE;
    }
}
