package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int YEAR_FROM_INDEX = 0;
    private static final int YEAR_TO_INDEX = 1;
    private static final int REQUIRED_YEARS_OF_LIVING = 10;
    private static final int REQUIRED_AGE = 35;

    @Override
    public boolean test(Candidate candidate) {
        String[] candidateLivingDate = candidate.getPeriodsInUkr().split("-");
        boolean candidateLivingIsValid = Integer.parseInt(candidateLivingDate[YEAR_TO_INDEX])
                - Integer.parseInt(candidateLivingDate[YEAR_FROM_INDEX])
                >= REQUIRED_YEARS_OF_LIVING;
        return candidate.isAllowedToVote()
                && candidate.getAge() >= REQUIRED_AGE
                && candidate.getNationality().equals("Ukrainian")
                && candidateLivingIsValid;
    }
}
