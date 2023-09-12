package practice;

import model.Candidate;
import java.util.Arrays;
import java.util.function.Predicate;

public class CandidateValidator implements Predicate<Candidate> {
    public boolean test(Candidate candidate) {
        int[] periodsInUkr = Arrays.stream(candidate.getPeriodsInUkr().split("-"))
                .mapToInt(Integer::parseInt)
                .toArray();
        return candidate.isAllowedToVote()
                && candidate.getNationality().equals("Ukrainian")
                && candidate.getAge() >= 35
                && periodsInUkr[1] - periodsInUkr[0] >= 10;
    }
}
