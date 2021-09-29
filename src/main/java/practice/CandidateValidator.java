package practice;

import java.util.Arrays;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    @Override
    public boolean test(Candidate candidate) {
        int[] periodsInUkr = Arrays.stream(candidate.getPeriodsInUkr().split("-"))
                .mapToInt(Integer::parseInt).toArray();
        boolean hasTenYearsInUkr = periodsInUkr[1] - periodsInUkr[0] >= 10;
        boolean isUkrainian = candidate.getNationality().equals("Ukrainian");
        boolean allowedAge = candidate.getAge() >= 35;
        return hasTenYearsInUkr && candidate.isAllowedToVote() && isUkrainian && allowedAge;
    }
}
