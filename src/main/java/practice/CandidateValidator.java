package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int requiredAge = 35;
    private static final int requiredPeriodsInUkr = 10;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= requiredAge && candidate.isAllowedToVote()
                && candidate.getNationality().equals("Ukrainian")
                && Integer.parseInt(candidate.getPeriodsInUkr().split("-")[1])
                - Integer.parseInt(candidate.getPeriodsInUkr().split("-")[0])
                >= requiredPeriodsInUkr;
    }
}
