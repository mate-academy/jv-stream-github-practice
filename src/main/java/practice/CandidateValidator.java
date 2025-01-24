package practice;

import java.util.Objects;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String VALID_NATIONALITY_VALUE = "Ukrainian";
    private static final String PERIOD_SPLIT_POINT = "-";
    private static final int MIN_AGE_VALUE = 35;
    private static final int MIN_AGE_GAP = 10;
    private static final int VALID_ARRAY_LENGTH = 2;
    private static final int FIRST_ARRAY_PART = 0;
    private static final int SECOND_ARRAY_PART = 1;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE_VALUE
                && Objects.equals(candidate.getNationality(), VALID_NATIONALITY_VALUE)
                && candidate.isAllowedToVote()
                && hasLivedInUkraineForTenYears(candidate.getPeriodsInUkr());
    }

    private boolean hasLivedInUkraineForTenYears(String periodInUkraine) {
        String[] periods = periodInUkraine.split(PERIOD_SPLIT_POINT);
        if (periods.length != VALID_ARRAY_LENGTH) {
            return false;
        }
        int startYear = Integer.parseInt(periods[FIRST_ARRAY_PART]);
        int endYear = Integer.parseInt(periods[SECOND_ARRAY_PART]);
        return (endYear - startYear) >= MIN_AGE_GAP;
    }
}
