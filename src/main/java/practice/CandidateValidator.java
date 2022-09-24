package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int REQUIRED_MIN_AGE = 35;
    private static final String REUIRED_NATIONALITY = "Ukrainian";
    private static final int PERIOD_TO_INDEX = 1;
    private static final int PERIOD_FROM_INDEX = 0;
    private static final int REQUIRED_PERIOD_IN_COUNTRY = 10;

    @Override
    public boolean test(Candidate candidate) {
        String[] splitted = candidate.getPeriodsInUkr().split("-");
        return (candidate.getAge() >= REQUIRED_MIN_AGE
                && candidate.getNationality().equals(REUIRED_NATIONALITY)
                && (Integer.parseInt(splitted[PERIOD_TO_INDEX])
                - Integer.parseInt(splitted[PERIOD_FROM_INDEX]) > REQUIRED_PERIOD_IN_COUNTRY)
                && candidate.isAllowedToVote());
    }
}

