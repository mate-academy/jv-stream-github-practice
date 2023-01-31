package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE_PRESIDENT = 35;
    private static final String NATIONALITY = "Ukrainian";
    private static final int MIN_PERIOD_LIVE_IN_UKRAINE = 10;
    private static final int DEADLINE_INDEX = 5;
    private static final int INDEX_ONE_OF_INITIAL_TERM = 0;
    private static final int INDEX_TWO_OF_INITIAL_TERM = 4;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE_PRESIDENT
                && candidate.getNationality().equals(NATIONALITY)
                && candidate.isAllowedToVote()
                && Integer.parseInt(candidate.getPeriodsInUkr()
                .substring(DEADLINE_INDEX)) - Integer
                .parseInt(candidate.getPeriodsInUkr()
                .substring(INDEX_ONE_OF_INITIAL_TERM, INDEX_TWO_OF_INITIAL_TERM))
                >= MIN_PERIOD_LIVE_IN_UKRAINE;
    }
}
