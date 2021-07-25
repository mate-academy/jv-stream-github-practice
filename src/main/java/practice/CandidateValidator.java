package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MINIMAL_AGE_OF_CANDIDATE = 35;
    private static final String CORRECT_NATIONALITY_FOR_CANDIDATE = "Ukrainian";
    private static final int CORRECT_LIVING_PERIOD_FOR_CANDIDATE = 10;
    private static final String PERIOD_SEPARATOR = "-";
    private static final int FIRST_PERIOD_INDEX = 0;
    private static final int SECOND_PERIOD_INDEX = 1;

    @Override
    public boolean test(Candidate candidate) {
        return candidate != null
                && candidate.getAge() >= MINIMAL_AGE_OF_CANDIDATE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(CORRECT_NATIONALITY_FOR_CANDIDATE)
                && isPeriodCorrect(candidate);
    }

    private boolean isPeriodCorrect(Candidate candidate) {
        String[] period = candidate.getPeriodsInUkr().split(PERIOD_SEPARATOR);
        int firstPeriod = Integer.parseInt(period[FIRST_PERIOD_INDEX]);
        int secondPeriod = Integer.parseInt(period[SECOND_PERIOD_INDEX]);
        return secondPeriod - firstPeriod >= CORRECT_LIVING_PERIOD_FOR_CANDIDATE;
    }
}
