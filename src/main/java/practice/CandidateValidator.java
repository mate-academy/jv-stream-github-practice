package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int fromAge = 35;
    private static final int periodsInUkr = 10;
    private static final String nationality = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= fromAge
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(nationality)
                && (Integer.parseInt(candidate.getPeriodsInUkr().split("-")[1])
                - Integer.parseInt(candidate.getPeriodsInUkr().split("-")[0]))
                > periodsInUkr;
    }
}
