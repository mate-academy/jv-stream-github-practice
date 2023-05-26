package practice;

import java.util.Arrays;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String UKRAINIAN_NATIONALITY = "Ukrainian";
    private static final int MIN_AGE = 35;
    private static final String HYPHEN_REGEX = "-";
    private static final int MIN_DURATION_OF_RESIDENCE_IN_UKRAINE = 10;
    private static final int INDEX_OF_FIRST_RESIDENCE_YEAR = 0;
    private static final int INDEX_OF_LAST_RESIDENCE_YEAR = 1;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE && candidate.isAllowedToVote()
                && candidate.getNationality().equals(UKRAINIAN_NATIONALITY)
                && checkPeriodsInUkr(candidate);
    }

    private boolean checkPeriodsInUkr(Candidate candidate) {
        int[] periodsInUkr = Arrays.stream(candidate.getPeriodsInUkr().split(HYPHEN_REGEX))
                .mapToInt(Integer::parseInt)
                .toArray();
        return periodsInUkr[INDEX_OF_LAST_RESIDENCE_YEAR]
                - periodsInUkr[INDEX_OF_FIRST_RESIDENCE_YEAR]
                >= MIN_DURATION_OF_RESIDENCE_IN_UKRAINE;
    }
    //write your code here
}
