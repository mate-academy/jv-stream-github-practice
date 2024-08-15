package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MINIMUM_AGE = 35;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";
    private static final int MINIMUM_YEARS_IN_UKRAINE = 10;

    @Override
    public boolean test(Candidate candidate) {
        int startPeriod = Integer.parseInt(candidate.getPeriodsInUkr().split("-")[0]);
        int endPeriod = Integer.parseInt(candidate.getPeriodsInUkr().split("-")[1]);
        return candidate.getAge() >= MINIMUM_AGE
                && candidate.getNationality().equals(REQUIRED_NATIONALITY)
                && candidate.isAllowedToVote()
                && (endPeriod - startPeriod) >= MINIMUM_YEARS_IN_UKRAINE;
    }
}
