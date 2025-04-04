package practice;

import java.util.Arrays;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int eligibleAge = 35;
    private static final String eligibleNationality = "Ukrainian";
    private static final int requiredPeriodInUkr = 10;

    @Override
    public boolean test(Candidate candidate) {
        if (candidate.getAge() >= eligibleAge
                && candidate.getNationality().equals(eligibleNationality)
                && candidate.isAllowedToVote()) {
            int[] period = Arrays.stream(candidate.getPeriodsInUkr().split("-"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            if (period[1] - period[0] >= requiredPeriodInUkr) {
                return true;
            }
        }
        return false;
    }
    //write your code here
}
