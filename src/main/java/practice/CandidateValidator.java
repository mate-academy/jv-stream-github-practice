package practice;

import java.util.Arrays;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int MIN_RESIDENCE_PERIOD = 10;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";
    private static final String DATE_SEPARATOR = "-";

    @Override
    public boolean test(Candidate candidate) {
        int residencePeriod = Arrays.stream(candidate.getPeriodsInUkr().split(DATE_SEPARATOR))
                .mapToInt(Integer::parseInt)
                .reduce(0, (a, b) -> a == 0 ? a - b : a + b);
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(REQUIRED_NATIONALITY)
                && residencePeriod >= MIN_RESIDENCE_PERIOD;
    }
}
