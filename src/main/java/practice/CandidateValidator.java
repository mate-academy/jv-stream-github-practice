package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MINIMUM_CANDIDATE_AGE = 35;
    private static final int MINIMUM_CANDIDATE_PERIOD_IN_UKRAINE = 10;
    private static final int INDEX_LAST_YEAR_RESIDENCY = 1;
    private static final int INDEX_INITIAL_YEAR_RESIDENCY = 0;

    @Override
    public boolean test(Candidate candidate) {
        String[] years = candidate.getPeriodsInUkr().split("-");
        return candidate.getAge() >= MINIMUM_CANDIDATE_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals("Ukrainian")
                && (Integer.parseInt(years[INDEX_LAST_YEAR_RESIDENCY])
                - Integer.parseInt(years[INDEX_INITIAL_YEAR_RESIDENCY]))
                > MINIMUM_CANDIDATE_PERIOD_IN_UKRAINE;
    }
}
