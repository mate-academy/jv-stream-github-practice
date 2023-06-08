package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_PERIOD_IN_UKR = 10;
    private static final int MIN_AGE_FOR_CANDIDATE_FOR_PRESIDENT = 35;
    private static final int FROM_AGE_INDEX = 0;
    private static final int TO_AGE_INDEX = 1;

    @Override
    public boolean test(Candidate candidate) {
        String[] split = candidate.getPeriodsInUkr().split("-");
        int periondInUkr = Integer.parseInt(split[TO_AGE_INDEX])
                - Integer.parseInt(split[FROM_AGE_INDEX]);

        return candidate.getAge() >= MIN_AGE_FOR_CANDIDATE_FOR_PRESIDENT
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals("Ukrainian")
                && periondInUkr >= MIN_PERIOD_IN_UKR;
    }
}
