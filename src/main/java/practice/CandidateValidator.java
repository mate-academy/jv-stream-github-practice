package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MINIMUM_AGE = 35;
    private static final int MINIMUM_AGES_IN_UKRAINE = 10;
    private static final String UKRAINIAN = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        int toYearLivingInUkraine = Integer.parseInt(candidate.getPeriodsInUkr().substring(5));
        int fromYearLivingInUkraine = Integer.parseInt(candidate.getPeriodsInUkr().substring(0,4));
        int yearsLivingInUkraine = toYearLivingInUkraine - fromYearLivingInUkraine;

        return candidate.getAge() >= MINIMUM_AGE && candidate.getNationality().equals(UKRAINIAN)
                && candidate.isAllowedToVote() && yearsLivingInUkraine >= MINIMUM_AGES_IN_UKRAINE;
    }
}
