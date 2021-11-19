package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final byte MIN_AGE_CANDIDATE = 35;
    private static final byte MIN_PERIOD_IN_UKR = 10;
    private static final byte PERIOD_IN_UKRAINE_START = 0;
    private static final byte PERIOD_IN_UKRAINE_END = 1;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        String[] period = candidate.getPeriodsInUkr().split("-");
        int yearsInUkraine = Integer.parseInt(period[PERIOD_IN_UKRAINE_END])
                - Integer.parseInt(period[PERIOD_IN_UKRAINE_START]);
        return candidate.getAge() >= MIN_AGE_CANDIDATE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(REQUIRED_NATIONALITY)
                && yearsInUkraine >= MIN_PERIOD_IN_UKR;
    }
}
