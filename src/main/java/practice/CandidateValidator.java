package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MINIMUM_AGE = 35;
    private static final String NATIONALITY_REQUIRED = "Ukrainian";
    private static final int MINIMUM_PERIOD_IN_UKRAINE = 10;

    @Override
    public boolean test(Candidate candidate) {
        return (candidate.getAge() >= MINIMUM_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY_REQUIRED)
                && hasLivedInUkraineForTenYears(candidate));
    }

    private boolean hasLivedInUkraineForTenYears(Candidate candidate) {
        String[] periodsInUkr = candidate.getPeriodsInUkr().split("-");
        return Integer.parseInt(periodsInUkr[1]) - Integer.parseInt(periodsInUkr[0])
                >= MINIMUM_PERIOD_IN_UKRAINE;
    }
}


