package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE_CANDIDATE = 35;
    private static final String NATIONALITY_CANDIDATE = "Ukrainian";
    private static final int MIN_PERIOD_IN_UKR = 10;
    private static final int START_OF_PERIOD = 0;
    private static final int END_OF_PERIOD = 1;

    @Override
    public boolean test(Candidate candidate) {
        int periodsInUkr = Integer.parseInt(candidate.getPeriodsInUkr().split("-")[END_OF_PERIOD])
                - Integer.parseInt(candidate.getPeriodsInUkr()
                        .split("-")[START_OF_PERIOD]);
        return candidate.getAge() >= MIN_AGE_CANDIDATE
                && candidate.getNationality().equals(NATIONALITY_CANDIDATE)
                && periodsInUkr >= MIN_PERIOD_IN_UKR
                && candidate.isAllowedToVote();
    }
}
