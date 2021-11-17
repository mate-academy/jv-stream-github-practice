package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_CANDIDATE_AGE = 35;
    private static final int MIN_PERIOD_IN_UKRAINE = 10;
    private static final int PERIOD_FROM_INDEX = 0;
    private static final int PERIOD_TO_INDEX = 1;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_CANDIDATE_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(REQUIRED_NATIONALITY)
                && periodInUkraine(candidate.getPeriodsInUkr()) >= MIN_PERIOD_IN_UKRAINE;
    }

    private int periodInUkraine(String period) {
        String[] periodAsArray = period.split("-");
        int periodFrom = Integer.parseInt(periodAsArray[PERIOD_FROM_INDEX]);
        int periodTo = Integer.parseInt(periodAsArray[PERIOD_TO_INDEX]);
        return periodTo - periodFrom;
    }
}
