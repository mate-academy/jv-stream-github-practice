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
        String[] livingTimes = candidate.getPeriodsInUkr().split(DIVIDER);
        int livingTime = Integer.parseInt(livingTimes[END_TERM_INDEX])
                - Integer.parseInt(livingTimes[START_TERM_INDEX]);
        return candidate.isAllowedToVote()
                && candidate.getAge() >= ALLOWED_AGE
                && candidate.getNationality().equals(ALLOWED_NATIONALITY)
                && livingTime >= ALLOWED_YEARS_OF_LIVING;
    }
}
