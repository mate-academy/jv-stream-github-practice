package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_VALID_AGE = 35;
    private static final int MIN_VALID_PERIOD_IN_UKR = 10;
    private static final String VALID_NATIONALITY = "ukrainian";
    private static final String DATE_SEPARATOR = "-";

    @Override
    public boolean test(Candidate candidate) {
        String[] periodsInUkr = candidate.getPeriodsInUkr().split(DATE_SEPARATOR);
        int periodFrom = Integer.parseInt(periodsInUkr[0]);
        int periodTo = Integer.parseInt(periodsInUkr[1]);
        int tenureInUkraine = periodTo - periodFrom;

        return candidate.getAge() >= MIN_VALID_AGE && candidate.isAllowedToVote()
                && candidate.getNationality().equalsIgnoreCase(VALID_NATIONALITY)
                && tenureInUkraine > MIN_VALID_PERIOD_IN_UKR;
    }
}
