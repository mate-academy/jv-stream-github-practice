package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final String NATIONALITY = "Ukrainian";
    private static final int FIRST_YEAR = 0;
    private static final int LAST_YEAR = 1;
    private static final int NEEDED_PERIOD = 10;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && (Integer.parseInt(candidate.getPeriodsInUkr().split("-")[LAST_YEAR])
                    - Integer.parseInt(candidate.getPeriodsInUkr().split("-")[FIRST_YEAR])
                    >= NEEDED_PERIOD);
    }
}
