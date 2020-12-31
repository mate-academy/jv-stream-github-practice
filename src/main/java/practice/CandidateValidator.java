package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE_CANDIDATE = 35;
    private static final int MIN_PERIOD_IN_UKR = 10;
    private static final String NATIONALITY_UKRAINE = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE_CANDIDATE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY_UKRAINE)
                && getPeriodCandidateInUkr(candidate) >= MIN_PERIOD_IN_UKR;
    }

    private int getPeriodCandidateInUkr(Candidate candidate) {
        return Integer.parseInt(candidate.getPeriodsInUkr()
                .substring(candidate.getPeriodsInUkr().indexOf("-") + 1))
                - Integer.parseInt(candidate.getPeriodsInUkr()
                .substring(0, candidate.getPeriodsInUkr().indexOf("-")));
    }
}
