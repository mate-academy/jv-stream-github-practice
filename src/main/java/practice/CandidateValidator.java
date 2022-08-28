package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    public static final int START_PERIOD_INDEX = 0;
    public static final int END_PERIOD_INDEX = 1;
    public static final int OLDER_THEN = 35;
    public static final int REQUARIED_MIN_PERIOD_IN_COUNTRY = 10;
    public static final String NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        int period = Integer.parseInt(candidate.getPeriodsInUkr().split("-")[END_PERIOD_INDEX])
                - Integer.parseInt(candidate.getPeriodsInUkr().split("-")[START_PERIOD_INDEX]);

        return candidate.getAge() >= OLDER_THEN
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && period >= REQUARIED_MIN_PERIOD_IN_COUNTRY;

    }
}
