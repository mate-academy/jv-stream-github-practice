package practice;

import java.util.Arrays;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int ELIGIBLE_AGE = 35;
    private static final String ELIGIBLE_NATIONALITY = "Ukrainian";
    private static final int REQUIRED_PERIOD_IN_UKR = 10;

    @Override
    public boolean test(Candidate candidate) {
        if (candidate.getAge() < ELIGIBLE_AGE) {
            return false;
        }

        if (!ELIGIBLE_NATIONALITY.equals(candidate.getNationality())) {
            return false;
        }

        if (!candidate.isAllowedToVote()) {
            return false;
        }

        int[] period = Arrays.stream(candidate.getPeriodsInUkr().split("-"))
                .mapToInt(Integer::parseInt)
                .toArray();

        return (period[1] - period[0]) >= REQUIRED_PERIOD_IN_UKR;
    }

}
