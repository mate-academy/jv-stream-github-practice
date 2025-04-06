package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int INITIAL_AGE_CANDIDATE = 35;
    private static final int DURATION_OF_STAY_IN_UKRAINE = 10;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";
    private static final int FIRST_INDEX_ARRAY = 0;
    private static final int SECOND_INDEX_ARRAY = 1;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= INITIAL_AGE_CANDIDATE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(REQUIRED_NATIONALITY)
                && periodsToInt(candidate.getPeriodsInUkr()) >= DURATION_OF_STAY_IN_UKRAINE;
    }
    
    private int periodsToInt(String period) {
        String[] periodToArray = period.split("-");
        return Integer.parseInt(periodToArray[SECOND_INDEX_ARRAY])
                - Integer.parseInt(periodToArray[FIRST_INDEX_ARRAY]);
    }
}
