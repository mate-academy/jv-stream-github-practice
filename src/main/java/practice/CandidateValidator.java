package practice;

import java.util.Arrays;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {

    private static final int MAX_AGE = 35;
    private static final int YEARS_IN_UKRAINE = 10;

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
