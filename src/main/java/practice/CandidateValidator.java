package practice;

import java.util.Arrays;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    int MAX_AGE = 35;
    int YEARS_IN_UKRAINE = 10;

    @Override
    public boolean test(Candidate candidate) {
        int[] yearsInUkraine = Arrays.stream(candidate.getPeriodsInUkr()
                        .split("-"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int years = yearsInUkraine[1] - yearsInUkraine[0];
        return candidate.getAge() >= MAX_AGE
                && candidate.getNationality().equals("Ukrainian")
                && years >= YEARS_IN_UKRAINE
                && candidate.isAllowedToVote();
    }
}
