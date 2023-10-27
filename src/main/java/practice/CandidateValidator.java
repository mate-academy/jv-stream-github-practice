package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int MIN_DURATION = 10;
    private static final int YEAR_FROM_INDEX = 0;
    private static final int YEAR_TO_INDEX = 1;
    private static final String NATIONALITY = "Ukrainian";
    private static final String REGEX = "-";

    @Override
    public boolean test(Candidate candidate) {
        if (candidate.getAge() >= MIN_AGE && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)) {
            String[] period = candidate.getPeriodsInUkr().split(REGEX);
            int totalDuration = Integer.parseInt(period[YEAR_TO_INDEX])
                    - Integer.parseInt(period[YEAR_FROM_INDEX]);
            return totalDuration >= MIN_DURATION;
        }
        return false;
    }
}
