package practice;

import java.util.Objects;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    public static final int MIN_ALLOWED_AGE = 35;
    public static final String ALLOWED_NATIONALITY = "Ukrainian";
    public static final String DELIMITER = "-";
    public static final int FROM = 0;
    public static final int TO = 1;
    public static final int MIN_ALLOWED_PERIOD = 10;

    @Override
    public boolean test(Candidate candidate) {
        if (candidate.getAge() < MIN_ALLOWED_AGE) {
            return false;
        }
        if (!candidate.isAllowedToVote()) {
            return false;
        }
        if (!Objects.equals(candidate.getNationality(), ALLOWED_NATIONALITY)) {
            return false;
        }
        String[] inUkraine = candidate.getPeriodsInUkr().split(DELIMITER);
        int period = Integer.parseInt(inUkraine[TO]) - Integer.parseInt(inUkraine[FROM]);
        if (period < MIN_ALLOWED_PERIOD) {
            return false;
        }
        return true;
    }
}
