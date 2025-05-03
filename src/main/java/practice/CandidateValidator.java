package practice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String NATIONALITY = "Ukrainian";
    private static final int MIN_AGE = 35;
    private static final int PERIOD = 10;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && validPeriod(candidate);
    }

    private boolean validPeriod(Candidate candidate) {
        return Arrays.stream(candidate.getPeriodsInUkr().split("-"))
                .map(Integer::parseInt)
                .sorted(Comparator.reverseOrder())
                .reduce((a, b) -> a - b)
                .get() >= PERIOD;
    }
    //write your code here
}
