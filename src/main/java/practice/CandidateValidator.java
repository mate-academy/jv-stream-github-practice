package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String NEEDED_NATIONALITY = "Ukrainian";
    private static final int NEEDED_AGE = 35;
    private static final int NEEDED_PERIOD_IN_UKRAINE = 10;

    @Override
    public boolean test(Candidate candidate) {
        String[] years = candidate.getPeriodsInUkr().split("-");
        int periodInUkraine = Integer.valueOf(years[1]) - Integer.valueOf(years[0]);
        return candidate.isAllowedToVote()
                && periodInUkraine >= NEEDED_PERIOD_IN_UKRAINE
                && candidate.getNationality().equals(NEEDED_NATIONALITY)
                && candidate.getAge() >= NEEDED_AGE;
    }
}
