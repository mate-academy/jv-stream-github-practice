package practice;

import java.util.Arrays;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    int CANDIDATE_MAX_AGE = 35;
    int LIVED_YEARS_IN_UKRAINE = 10;

    @Override
    public boolean test(Candidate candidate) {
        int[] yearsInUkraine = Arrays.stream(candidate.getPeriodsInUkr()
                        .split("-"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int years = yearsInUkraine[1] - yearsInUkraine[0];
        return candidate.getAge() >= CANDIDATE_MAX_AGE
                && candidate.getNationality().equals("Ukrainian")
                && years >= LIVED_YEARS_IN_UKRAINE
                && candidate.isAllowedToVote();
    }
}
