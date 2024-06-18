package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int REQUIRED_AGE_TO_VOTE = 35;
    private static final String REQUIRED_NATIONALITY_TO_VOTE = "Ukrainian";
    private static final String CHARACTER_FOR_SPLIT = "-";
    private static final int DATE_FROM_INDEX = 0;
    private static final int DATE_TO_INDEX = 1;
    private static final int SHOULD_LIVE_IN_UKRAINE_YEARS = 10;

    @Override
    public boolean test(Candidate candidate) {
        String[] periodInUkr = candidate.getPeriodsInUkr().split(CHARACTER_FOR_SPLIT);

        return candidate.getAge() >= REQUIRED_AGE_TO_VOTE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(REQUIRED_NATIONALITY_TO_VOTE)
                && (Integer.parseInt(periodInUkr[DATE_TO_INDEX])
                    -
                    Integer.parseInt(periodInUkr[DATE_FROM_INDEX])
                    >= SHOULD_LIVE_IN_UKRAINE_YEARS);
    }
}
