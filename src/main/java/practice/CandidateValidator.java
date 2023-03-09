package practice;

import java.util.Arrays;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    @Override
    public boolean test(Candidate candidate) {
        final int[] parsedPeriod = Arrays.stream(candidate.getPeriodsInUkr().split("-"))
                .mapToInt(Integer::valueOf).toArray();
        return candidate.isAllowedToVote()
                && candidate.getAge() >= 35
                && candidate.getNationality().equals("Ukrainian")
                && parsedPeriod[1] - parsedPeriod[0] > 10;
    }
}
