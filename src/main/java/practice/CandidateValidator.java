package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int ALLOWED_AGE = 35;
    private static final int ALLOWED_YEARS_OF_LIVING = 10;
    private static final int START_TERM_INDEX = 0;
    private static final int END_TERM_INDEX = 1;
    private static final String ALLOWED_NATIONALITY = "Ukrainian";
    private static final String DIVIDER = "-";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.isAllowedToVote()
                && candidate.getAge() >= ALLOWED_AGE
                && candidate.getNationality().equals(ALLOWED_NATIONALITY)
                && getLivingTime(candidate) >= ALLOWED_YEARS_OF_LIVING;
    }

    private int getLivingTime(Candidate candidate) {
        String[] durationOfResidence = candidate.getPeriodsInUkr().split(DIVIDER);
        return Integer.parseInt(durationOfResidence[END_TERM_INDEX])
                - Integer.parseInt(durationOfResidence[START_TERM_INDEX]);
    }
}
