package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE_TO_VOTE = 35;
    private static final int MIN_LIVING_IN_UKRAINE = 10;
    private static final String UA_NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        return Integer.parseInt(candidate.getPeriodsInUkr().split("-")[1])
                - Integer.parseInt(candidate.getPeriodsInUkr().split("-")[0])
                >= MIN_LIVING_IN_UKRAINE
                && candidate.isAllowedToVote() && candidate.getAge() >= MIN_AGE_TO_VOTE
                && candidate.getNationality().equals(UA_NATIONALITY);
    }
}
