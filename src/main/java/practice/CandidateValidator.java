package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int PERMISSIBLE_AGE_FOR_CANDIDATES = 35;
    private static final int MIN_PERIOD_IN_UKRAINE = 10;
    private static final String EXPECTED_NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        String[] periods = candidate.getPeriodsInUkr().split("-");
        int yearOfArrival = Integer.parseInt(periods[0]);
        int currentYear = Integer.parseInt(periods[1]);
        return candidate.getAge() >= PERMISSIBLE_AGE_FOR_CANDIDATES
                && candidate.getNationality().equals(EXPECTED_NATIONALITY)
                && currentYear - yearOfArrival >= MIN_PERIOD_IN_UKRAINE
                && candidate.isAllowedToVote();
    }
}
