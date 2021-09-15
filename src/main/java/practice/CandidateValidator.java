package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int VALID_CANDIDATE_AGE = 35;
    private static final String NATIONALITY = "Ukrainian";
    private static final int INDEX_PERIOD_IN_UKRAINE_START = 0;
    private static final int INDEX_PERIOD_IN_UKRAINE_END = 1;
    private static final int VALID_PERIOD_IN_UKRAINE = 10;

    @Override
    public boolean test(Candidate candidate) {
        String[] periodInUkraine = candidate.getPeriodsInUkr().split("-");
        int periodInUkraineStart = Integer.parseInt(periodInUkraine[INDEX_PERIOD_IN_UKRAINE_START]);
        int periodInUkraineFinish = Integer.parseInt(periodInUkraine[INDEX_PERIOD_IN_UKRAINE_END]);
        return candidate.isAllowedToVote()
                && candidate.getAge() >= VALID_CANDIDATE_AGE
                && candidate.getNationality().equals(NATIONALITY)
                && periodInUkraineFinish - periodInUkraineStart > VALID_PERIOD_IN_UKRAINE;
    }
}
