package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_CANDIDATE_AGE = 35;
    private static final int MIN_VALID_PERIOD = 10;
    private static final int YEAR_TO_INDEX = 1;
    private static final int YEAR_FROM_INDEX = 0;

    @Override
    public boolean test(Candidate candidate) {
        String[] splitedArray = candidate.getPeriodsInUkr().split("-");
        int periodDuration = Integer.parseInt(splitedArray[YEAR_TO_INDEX])
                - Integer.parseInt(splitedArray[YEAR_FROM_INDEX]);
        return candidate.getAge() >= MIN_CANDIDATE_AGE
                && candidate.getNationality().equals("Ukrainian")
                && candidate.isAllowedToVote()
                && periodDuration >= MIN_VALID_PERIOD;
    }
}
