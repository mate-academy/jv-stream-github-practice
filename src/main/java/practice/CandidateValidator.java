package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MINIMUM_AGE = 35;
    private static final int MINIMUM_AGES_IN_UKRAINE = 10;
    private static final int ZERO_INDEX = 0;
    private static final int FIRST_INDEX = 1;
    private static final String UKRAINIAN = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        String[] periodInUkraine = candidate.getPeriodsInUkr().split("-");
        int yearsLivingInUkraine = Integer.parseInt(periodInUkraine[FIRST_INDEX])
                - Integer.parseInt(periodInUkraine[ZERO_INDEX]);
        return candidate.getAge() >= MINIMUM_AGE && candidate.getNationality().equals(UKRAINIAN)
                && candidate.isAllowedToVote() && yearsLivingInUkraine >= MINIMUM_AGES_IN_UKRAINE;
    }
}
