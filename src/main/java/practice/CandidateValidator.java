package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AEG_CANDIDATE = 35;
    private static final String NATIONALITY_CANDIDATE = "Ukrainian";
    private static final int MIN_PERIOD_IN_UKR = 10;

    @Override
    public boolean test(Candidate candidate) {
        int periodsInUkr = Integer.parseInt(candidate.getPeriodsInUkr().split("-")[1])
                - Integer.parseInt(candidate.getPeriodsInUkr()
                        .split("-")[0]);
        return candidate.getAge() >= MIN_AEG_CANDIDATE
                && candidate.getNationality().equals(NATIONALITY_CANDIDATE)
                && periodsInUkr >= MIN_PERIOD_IN_UKR
                && candidate.isAllowedToVote();
    }
}
