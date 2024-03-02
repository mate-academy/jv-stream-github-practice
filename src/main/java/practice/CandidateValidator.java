package practice;

import java.util.Arrays;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    public static final int MIN_AGE_FOR_CANDIDATE = 35;
    public static final String NATIONALITY = "Ukrainian";
    public static final int MIN_YEARS_IN_UKRAINE = 10;
    public static final int INDEX_OF_FIRST_YEAR_IN_UKRAINE = 0;
    public static final int INDEX_OF_LAST_YEAR_IN_UKRAINE = 1;

    @Override
    public boolean test(Candidate candidate) {
        int[] intPeriod = Arrays.stream(candidate.getPeriodsInUkr().split("-"))
                .mapToInt(Integer::parseInt)
                .toArray();
        return candidate.isAllowedToVote() && candidate.getAge() >= MIN_AGE_FOR_CANDIDATE
                && candidate.getNationality().equals(NATIONALITY)
                && intPeriod[INDEX_OF_LAST_YEAR_IN_UKRAINE]
                - intPeriod[INDEX_OF_FIRST_YEAR_IN_UKRAINE] >= MIN_YEARS_IN_UKRAINE;
    }
}
