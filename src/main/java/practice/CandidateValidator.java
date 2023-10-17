package practice;

import java.util.Arrays;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_YEARS_LIVED = 10;
    private static final int MIN_AGE = 35;
    private static final int FIRST_YEAR_INDEX = 0;
    private static final int SECOND_YEAR_INDEX = 1;
    private static final String NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        int[] yearsLived = Arrays.stream(candidate
                        .getPeriodsInUkr()
                        .split("-"))
                .mapToInt(Integer::valueOf)
                .toArray();
        boolean hasLivedTenYears = (yearsLived[SECOND_YEAR_INDEX] - yearsLived[FIRST_YEAR_INDEX])
                > MIN_YEARS_LIVED;

        return candidate.isAllowedToVote()
            && candidate.getNationality() == NATIONALITY
            && candidate.getAge() >= MIN_AGE
            && hasLivedTenYears;
    }
}
