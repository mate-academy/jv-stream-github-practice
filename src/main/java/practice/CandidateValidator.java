package practice;

import java.util.Arrays;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int FROMAGE = 35;
    private static final int YEARSINUKRAINE = 10;

    @Override
    public boolean test(Candidate candidate) {
        if (candidate.getAge() >= FROMAGE && candidate.isAllowedToVote()
                && candidate.getNationality().equals("Ukrainian")) {
            int[] split = Arrays.stream(candidate.getPeriodsInUkr()
                            .split("-"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            return split[1] - split[0] >= YEARSINUKRAINE;
        }
        return false;
    }
}
