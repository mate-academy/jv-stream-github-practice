package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int IN_UKR = 0;
    private static final int OUT_UKR = 1;
    private static final int MIN_TERM = 10;
    private static final int MIN_AGE = 35;
    private static final String NATIONALITY = "Ukrainian";
    private static final String SEPARATOR = "-";

    @Override
    public boolean test(Candidate candidate) {
        String[] periodsInUkr = candidate.getPeriodsInUkr().split(SEPARATOR);
        int term = Integer.parseInt(periodsInUkr[OUT_UKR])
                - Integer.parseInt(periodsInUkr[IN_UKR]);
        return candidate.getAge() >= MIN_AGE
                && candidate.getNationality().equals(NATIONALITY)
                && candidate.isAllowedToVote()
                && term >= MIN_TERM;
    }
}
