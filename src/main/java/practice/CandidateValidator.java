package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MINIMAL_AGE = 35;
    private static final String NATIONALITY = "Ukrainian";
    private static final int MINIMAL_LIVE_IN_UKRAINE = 10;
    private static final int INDEX_YEAR_FIRST = 0;
    private static final int INDEX_YEAR_LAST = 1;

    @Override
    public boolean test(Candidate candidate) {
        String[] yearsLiveInUkraine = candidate.getPeriodsInUkr().split("-");
        int numberYearsLiveInUkraine = Integer.parseInt(yearsLiveInUkraine[INDEX_YEAR_LAST])
                - Integer.parseInt(yearsLiveInUkraine[INDEX_YEAR_FIRST]);
        return candidate.getAge() >= MINIMAL_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && numberYearsLiveInUkraine >= MINIMAL_LIVE_IN_UKRAINE;
    }
}
