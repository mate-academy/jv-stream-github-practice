package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int AGE_REQUIREMENT = 35;
    private static final int LIVE_REQUIREMENT = 10;
    private static final String NATIONAL_REQUIREMENT = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        if (candidate.getClass() != Candidate.class) {
            return false;
        }
        if (!candidate.isAllowedToVote()) {
            return false;
        }
        if (candidate.getAge() < AGE_REQUIREMENT) {
            return false;
        }
        if (!candidate.getNationality().equals(NATIONAL_REQUIREMENT)) {
            return false;
        }
        String[] years = candidate.getPeriodsInUkr().split("-");
        int yearInUkraine = Integer.valueOf(years[1]) - Integer.valueOf(years[0]);
        if (yearInUkraine < LIVE_REQUIREMENT) {
            return false;
        }
        return true;
    }
}
