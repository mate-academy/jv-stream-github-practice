package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String NATIONALITY_TO_VOTE = "Ukrainian";
    private static final int MIN_AGE_TO_VOTE = 35;
    private static final int MIN_YEARS_LIVE_TO_VOTE = 10;

    @Override
    public boolean test(Candidate candidate) {
        StringBuilder periodInUkrStr = new StringBuilder(candidate.getPeriodsInUkr());
        return (candidate.getAge() >= MIN_AGE_TO_VOTE
                   && candidate.getNationality().equals(NATIONALITY_TO_VOTE))
            && (candidate.isAllowedToVote())
            && (Integer.parseInt(periodInUkrStr.substring(periodInUkrStr.indexOf("-") + 1))
                   - Integer.parseInt(periodInUkrStr.substring(0, periodInUkrStr.indexOf("-"))))
                > MIN_YEARS_LIVE_TO_VOTE;
    }
}
