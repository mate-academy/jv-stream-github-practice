package practice;

import java.util.Arrays;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {

    private static final int REQUIRED_MIN_AGE = 35;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";
    private static final int REQUIRED_MIN_PERIOD = 10;
    private static final String SEPARATOR_HYPHEN = "-";

    @Override
    public boolean test(Candidate candidate) {
        final int[] parsedPeriod = Arrays.stream(candidate
                        .getPeriodsInUkr()
                        .split(SEPARATOR_HYPHEN))
                .mapToInt(Integer::valueOf)
                .toArray();
        return candidate.isAllowedToVote()
                && candidate.getAge() >= REQUIRED_MIN_AGE
                && candidate.getNationality().equals(REQUIRED_NATIONALITY)
                && parsedPeriod[1] - parsedPeriod[0] > REQUIRED_MIN_PERIOD;
    }
}
