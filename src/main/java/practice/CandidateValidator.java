package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int FIRST_YEAR = 0;
    private static final int LAST_YEAR = 1;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= 35
                && candidate.getNationality().equals("Ukrainian")
                && candidate.isAllowedToVote()
                && Integer.parseInt(candidate.getPeriodsInUkr().split("-")[LAST_YEAR])
                - Integer.parseInt(candidate.getPeriodsInUkr().split("-")[FIRST_YEAR]) >= 10;
    }
}
