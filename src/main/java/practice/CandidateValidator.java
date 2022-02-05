package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MINIMAL_AGE = 35;
    private static final String NATIONALITY = "Ukrainian";
    private static final int MINIMAL_LIVE_IN_UKRAINE = 10;

    @Override
    public boolean test(Candidate candidate) {
        String[] yearsLiveInUkraine = candidate.getPeriodsInUkr().split("-");
        int numberYearsLiveInUkraine = Integer.parseInt(yearsLiveInUkraine[1])
                - Integer.parseInt(yearsLiveInUkraine[0]);
        return candidate.getAge() >= MINIMAL_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && numberYearsLiveInUkraine >= MINIMAL_LIVE_IN_UKRAINE;
    }
}
