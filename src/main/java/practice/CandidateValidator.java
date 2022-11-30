package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int REQUIRED_PRESIDENT_AGE = 35;
    private static final int REQUIRED_PERIOD_UKRAINIAN_RESIDENT = 10;
    private static final int INDEX_SINCE = 0;
    private static final int INDEX_TO = 1;
    private static final String REQUIRED_PRESIDENT_NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.isAllowedToVote()
                && candidate.getAge() >= REQUIRED_PRESIDENT_AGE
                && candidate.getNationality().equals(REQUIRED_PRESIDENT_NATIONALITY)
                && Integer.parseInt(candidate.getPeriodsInUkr().split("-")[INDEX_TO])
                - Integer.parseInt(candidate.getPeriodsInUkr().split("-")[INDEX_SINCE])
                >= REQUIRED_PERIOD_UKRAINIAN_RESIDENT;
    }
}
