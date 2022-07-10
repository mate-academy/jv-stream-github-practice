package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int AGE_OF_ELIGIBILITY_FOR_ELECTION = 35;
    private static final int YEARS_OF_RESIDENTIAL = 10;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= AGE_OF_ELIGIBILITY_FOR_ELECTION
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals("Ukrainian")
                && Integer.parseInt(candidate.getPeriodsInUkr().substring(5))
                - Integer.parseInt(candidate.getPeriodsInUkr().substring(0, 4))
                >= YEARS_OF_RESIDENTIAL;
    }
}
