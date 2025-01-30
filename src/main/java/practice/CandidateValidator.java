package practice;

import java.util.Arrays;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    @Override
    public boolean test(Candidate candidate) {
        if (candidate.getAge() >= 35 && candidate.isAllowedToVote()
                && candidate.getNationality().equals("Ukrainian")) {
            int[] split = Arrays.stream(candidate.getPeriodsInUkr()
                            .split("-"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            return split[1] - split[0] >= 10;
        }
        return false;
    }
}
