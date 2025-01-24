package practice;

import java.util.Objects;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String VALID_NATIONALITY_VALUE = "Ukrainian";
    private static final String PERIOD_SPLIT_POINT = "-";
    private static final int MIN_AGE_VALUE = 35;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE_VALUE
                && Objects.equals(candidate.getNationality(), VALID_NATIONALITY_VALUE)
                && candidate.isAllowedToVote()
                && hasLivedInUkraineForTenYears(candidate.getPeriodsInUkr());
    }

    private boolean hasLivedInUkraineForTenYears(String periodInUkraine) {
        String[] periods = periodInUkraine.split(PERIOD_SPLIT_POINT);
        if (periods.length != 2) {
            return false;
        }
        int startYear = Integer.parseInt(periods[0]);
        int endYear = Integer.parseInt(periods[1]);
        return (endYear - startYear) >= 10;
    }
}
