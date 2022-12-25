package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {

    public static final String VALID_NATIONALITY = "Ukrainian";
    public static final int PERIOD_TO = 1;
    public static final int PERIOD_FROM = 0;
    public static final int VALID_PERIOD = 10;
    public static final int VALID_AGE = 35;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.isAllowedToVote()
                && candidate.getNationality().equals(VALID_NATIONALITY)
                && candidate.getAge() >= VALID_AGE
                && Integer.parseInt(candidate
                .getPeriodsInUkr()
                .split("-")[PERIOD_TO])
                - Integer.parseInt(candidate
                .getPeriodsInUkr()
                .split("-")[PERIOD_FROM]) >= VALID_PERIOD;
    }
}
