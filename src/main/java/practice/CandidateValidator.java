package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE_FOR_CANDIDATE = 35;
    private static final int MIN_YEAR_LIVE_IN_UKRAINE = 10;
    private static final String SEPARATOR = "-";
    private static final int CANDIDATE_INDEX_ZERO = 0;
    private static final int CANDIDATE_INDEX_ONE = 1;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE_FOR_CANDIDATE && candidate.isAllowedToVote()
                && candidate.getNationality().equals("Ukrainian")
                && (Integer.parseInt(candidate.getPeriodsInUkr()
                .split(SEPARATOR)[CANDIDATE_INDEX_ONE])
                - (Integer.parseInt(candidate.getPeriodsInUkr()
                .split(SEPARATOR)[CANDIDATE_INDEX_ZERO])) > MIN_YEAR_LIVE_IN_UKRAINE);
    }
    //write your code here
}
