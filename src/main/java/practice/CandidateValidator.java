package practice;

import java.util.Objects;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    public static final int MIN_ALLOWED_AGE = 35;
    public static final String ALLOWED_NATIONALITY = "Ukrainian";
    public static final String DELIMITER = "-";
    public static final int PERIOD_START_INDEX = 0;
    public static final int PERIOD_END_INDEX = 1;
    public static final int MIN_ALLOWED_PERIOD = 10;

    @Override
    public boolean test(Candidate candidate) {
        String[] inUkraine = candidate.getPeriodsInUkr().split(DELIMITER);
        int period = Integer.parseInt(inUkraine[PERIOD_END_INDEX])
                - Integer.parseInt(inUkraine[PERIOD_START_INDEX]);
        return candidate.getAge() >= MIN_ALLOWED_AGE
                && candidate.isAllowedToVote()
                && Objects.equals(candidate.getNationality(), ALLOWED_NATIONALITY)
                && period >= MIN_ALLOWED_PERIOD;
    }
}
