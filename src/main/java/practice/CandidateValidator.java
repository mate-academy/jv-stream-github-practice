package practice;

import java.util.Arrays;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";
    private static final int PERIOD_RESIDENCE = 10;
    private static final int INDEX_START_OF_STAY = 0;
    private static final int INDEX_END_OF_STAY = 1;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE && candidate.isAllowedToVote()
                && candidate.getNationality().equals(REQUIRED_NATIONALITY)
                && PERIOD_RESIDENCE <= calculatePeriod(candidate);
    }

    private int calculatePeriod(Candidate candidate) {
        int[] data = Arrays.stream(candidate.getPeriodsInUkr().split("-"))
                .mapToInt(Integer::parseInt)
                .toArray();
        return data[INDEX_END_OF_STAY] - data[INDEX_START_OF_STAY];
    }
}
