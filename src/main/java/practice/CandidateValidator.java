package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= 35
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals("Ukrainian")
                && isTenYearsInUkr(candidate);
    }

    private boolean isTenYearsInUkr(Candidate candidate) {
        String[] arr = candidate.getPeriodsInUkr().split("-");
        return Integer.parseInt(arr[1]) - Integer.parseInt(arr[0]) >= 10;
    }
}
