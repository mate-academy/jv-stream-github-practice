package practice;

import java.util.Arrays;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {

    @Override
    public boolean test(Candidate candidate) {
        int[] yearsInUkraine = Arrays.stream(candidate.getPeriodsInUkr()
                        .split("-"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int years = yearsInUkraine[1] - yearsInUkraine[0];
        return candidate.getAge() >= 35
                && candidate.getNationality().equals("Ukrainian")
                && years >= 10
                && candidate.isAllowedToVote();
    }
}
