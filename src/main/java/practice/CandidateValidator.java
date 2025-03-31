package practice;

import java.util.Arrays;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int ELIGIBLE_AGE = 35;
    private static final String ELIGIBLE_NATIONALITY = "Ukrainian";
    private static final int REQUIRED_PERIOD_IN_UKR = 10;
    private static final String DELIMITER = "-";

    @Override
    public boolean test(Candidate candidate) {
        if (candidate.getAge() >= ELIGIBLE_AGE
                && candidate.getNationality().equals(ELIGIBLE_NATIONALITY)
                && candidate.isAllowedToVote()) {
            int[] period = Arrays.stream(candidate.getPeriodsInUkr().split(DELIMITER))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            if (period[1] - period[0] >= REQUIRED_PERIOD_IN_UKR) {
                return true;
            }
        }
        return false;
    }
    //write your code here
}
