package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int YEAR_FROM_INDEX = 0;
    private static final int YEAR_TO_INDEX = 1;

    @Override
    public boolean test(Candidate candidate) {
        String[] candidateLivingDate = candidate.getPeriodsInUkr().split("-");
        boolean candidateLivingIsValid = Integer.parseInt(candidateLivingDate[YEAR_TO_INDEX])
                - Integer.parseInt(candidateLivingDate[YEAR_FROM_INDEX])
                >= 10;
        return candidate.isAllowedToVote()
                && candidate.getAge() >= 35
                && candidate.getNationality().equals("Ukrainian")
                && candidateLivingIsValid;
    }
}
