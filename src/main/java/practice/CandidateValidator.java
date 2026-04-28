package practice;

import java.util.Objects;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int MIN_PERIOD = 10;
    private static final String UKRAINIAN = "Ukrainian";

    @Override
    public boolean test(Candidate c) {
        String[] parts = c.getPeriodsInUkr().split("-");
        int start = Integer.parseInt(parts[0]);
        int end = Integer.parseInt(parts[1]);
        return c.getAge() >= MIN_AGE
                && c.isAllowedToVote()
                && Objects.equals(c.getNationality(), UKRAINIAN)
                && end - start >= MIN_PERIOD;
    }
}
