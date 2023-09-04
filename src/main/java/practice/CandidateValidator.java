package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String VALID_NATIONALITY = "Ukrainian";
    private static final int MINIMAL_CANDIDATES_AGE = 35;
    private static final int MINIMAL_PERIOD_LIVING_IN_UKRAINE = 10;
    private static final int INDEX_START_YEAR = 0;
    private static final int INDEX_FINISH_YEAR = 1;

    @Override
    public boolean test(Candidate candidate) {
        String[] years = candidate.getPeriodsInUkr().split("-");
        int periodLivingInUkraine = Integer.parseInt(years[INDEX_FINISH_YEAR])
                - Integer.parseInt(years[INDEX_START_YEAR]);
        return candidate.getAge() >= MINIMAL_CANDIDATES_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(VALID_NATIONALITY)
                && periodLivingInUkraine >= MINIMAL_PERIOD_LIVING_IN_UKRAINE;
    }
}
