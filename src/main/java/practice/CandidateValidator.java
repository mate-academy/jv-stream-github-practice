package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String NATIONALITY = "Ukrainian";
    private static final int MIN_PERIOD_LIVE_IN_COUNTRY = 10;
    private static final int MIN_AGE_CANDIDATE = 35;

    @Override
    public boolean test(Candidate candidate) {
        int positionSplitterLine = candidate.getPeriodsInUkr().indexOf("-");
        return candidate.isAllowedToVote()
                && candidate.getAge() >= MIN_AGE_CANDIDATE
                && candidate.getNationality().equals(NATIONALITY)
                && (Integer.parseInt(candidate.getPeriodsInUkr()
                .substring(positionSplitterLine + 1)))
                - (Integer.parseInt(candidate.getPeriodsInUkr()
                .substring(0, positionSplitterLine))) > MIN_PERIOD_LIVE_IN_COUNTRY;
    }
}
