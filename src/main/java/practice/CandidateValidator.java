package practice;

import java.util.Arrays;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    public static final int MIN_AGE = 35;
    public static final String REQUIRED_NATIONALITY = "Ukrainian";
    public static final int REQUIRED_PERIOD = 10;

    @Override
    public boolean test(Candidate candidate) {
        int periodInUkr = Arrays.stream(candidate.getPeriodsInUkr().split("-"))
                .mapToInt(Integer::parseInt)
                .reduce((x, y) -> y - x)
                .getAsInt();

        return candidate.getAge() >= MIN_AGE
                && candidate.getNationality().equals(REQUIRED_NATIONALITY)
                && periodInUkr >= REQUIRED_PERIOD
                && candidate.isAllowedToVote();
    }
}
