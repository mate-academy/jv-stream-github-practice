package practice;

import java.util.NoSuchElementException;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int AGE_REQUIREMENT = 35;
    private static final int LIVE_REQUIREMENT = 10;
    private static final String NATIONAL_REQUIREMENT = "Ukrainian";

    public boolean isValid(Candidate candidate) {
        return test(candidate);
    }

    @Override
    public boolean test(Candidate candidate) {
        if (!candidate.isAllowedToVote()
                || candidate.getAge() < AGE_REQUIREMENT
                || !candidate.getNationality().equals(NATIONAL_REQUIREMENT)) {
            return false;
        }
        String[] years = candidate.getPeriodsInUkr().split("-");
        if (years.length != 2) {
            throw new NoSuchElementException("Parse error for checking candidates leaving period");
        }
        int yearInUkraine = Integer.parseInt(years[1]) - Integer.parseInt(years[0]);
        return yearInUkraine >= LIVE_REQUIREMENT;
    }
}
