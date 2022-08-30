package practice;

import java.util.Arrays;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int REQUIRED_MIN_AGE = 35;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";
    private static final int MIN_PERIOD_IN_COUNTRY = 10;
    private static final int PERIOD_TO_INDEX = 1;
    private static final int PERIOD_FROM_INDEX = 0;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= REQUIRED_MIN_AGE
                && candidate.getNationality().equals(REQUIRED_NATIONALITY)
                && periodsInUkraine(candidate.getPeriodsInUkr()) > MIN_PERIOD_IN_COUNTRY
                && candidate.isAllowedToVote();
    }

    private int periodsInUkraine(String periodsInUkr) {
        String[] splitted = periodsInUkr.split("-");
        return Integer.parseInt(splitted[PERIOD_TO_INDEX]) - Integer.parseInt(splitted[PERIOD_FROM_INDEX]);
    }
}
