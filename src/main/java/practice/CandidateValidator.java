package practice;

import java.util.Arrays;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String NATIONALITY = "Ukrainian";
    private static final int MIN_AGE = 35;
    private static final int MIN_PERIOD = 10;

    @Override
    public boolean test(Candidate candidate) {
        int[] periods = Arrays.stream(candidate.getPeriodsInUkr().split("-"))
                .mapToInt(Integer::parseInt)
                .toArray();
        return candidate.isAllowedToVote()
                && NATIONALITY.equals(candidate.getNationality())
                && candidate.getAge() >= MIN_AGE
                && periods[1]
                - periods[0]
                >= MIN_PERIOD;
    }
}
