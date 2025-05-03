package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    public static final int START_PERIOD_INDEX = 0;
    public static final int END_PERIOD_INDEX = 1;
    public static final int REQUIRED_MIN_AGE = 35;
    public static final int REQUARIED_MIN_PERIOD_IN_COUNTRY = 10;
    public static final String NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        String[] splitted = candidate.getPeriodsInUkr().split("-");
        int period = Integer.parseInt(splitted[END_PERIOD_INDEX])
                - Integer.parseInt(splitted[START_PERIOD_INDEX]);

        return candidate.getAge() >= REQUIRED_MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && period >= REQUARIED_MIN_PERIOD_IN_COUNTRY;

    }
}
