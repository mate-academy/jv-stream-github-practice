package practice;

import java.util.Arrays;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {

    public static final int REQUIRED_MIN_AGE = 35;
    public static final String REQUIRED_NATIONALITY = "Ukrainian";
    public static final int REQUIRED_MIN_PERIOD = 10;

    @Override
    public boolean test(Candidate candidate) {
        final int[] parsedPeriod = Arrays.stream(candidate.getPeriodsInUkr().split("-"))
                .mapToInt(Integer::valueOf).toArray();
        return candidate.isAllowedToVote()
                && candidate.getAge() >= REQUIRED_MIN_AGE
                && candidate.getNationality().equals(REQUIRED_NATIONALITY)
                && parsedPeriod[1] - parsedPeriod[0] > REQUIRED_MIN_PERIOD;
    }
}
