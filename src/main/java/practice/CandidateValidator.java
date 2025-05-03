package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MINIMUM_AGE = 35;
    private static final int FIRST_INDEX_FROM_YEAR = 0;
    private static final int SECOND_INDEX_FROM_YEAR = 4;
    private static final int FIRST_INDEX_TO_YEAR = 5;
    private static final int SECOND_INDEX_TO_YEAR = 9;
    private static final int DURATION_OF_STAY = 10;
    private static final String NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.isAllowedToVote()
                && candidate.getAge() >= MINIMUM_AGE
                && candidate.getNationality().equals(NATIONALITY)
                && periodsInUkraine(candidate.getPeriodsInUkr()) >= DURATION_OF_STAY;
    }

    private int periodsInUkraine(String value) {
        return Integer.parseInt(value
                .substring(FIRST_INDEX_TO_YEAR, SECOND_INDEX_TO_YEAR))
                - Integer.parseInt(value
                .substring(FIRST_INDEX_FROM_YEAR, SECOND_INDEX_FROM_YEAR));
    }
}
