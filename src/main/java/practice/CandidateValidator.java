package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int AGE = 35;
    private static final int FIRST_INDEX_FROM_YEAR = 0;
    private static final int SECOND_INDEX_FROM_YEAR = 4;
    private static final int FIRST_INDEX_TO_YEAR = 5;
    private static final int SECOND_INDEX_TO_YEAR = 9;
    private static final int DURATION_OF_STAY = 10;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.isAllowedToVote()
                && candidate.getAge() >= AGE
                && candidate.getNationality().equals("Ukrainian")
                && Integer.parseInt(candidate.getPeriodsInUkr()
                .substring(FIRST_INDEX_TO_YEAR, SECOND_INDEX_TO_YEAR))
                - Integer.parseInt(candidate.getPeriodsInUkr()
                .substring(FIRST_INDEX_FROM_YEAR, SECOND_INDEX_FROM_YEAR)) >= DURATION_OF_STAY;
    }
}
