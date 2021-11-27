package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String PRESIDENT_NATIONALITY = "Ukrainian";
    private static final int PRESIDENT_AGE = 35;
    private static final int PRESIDENT_IN_UKRAINE = 10;

    @Override
    public boolean test(Candidate candidate) {
        String[] years = candidate.getPeriodsInUkr().split("-");
        int periodInUkraine = Integer.valueOf(years[1]) - Integer.valueOf(years[0]);
        boolean trueCandidate = candidate.isAllowedToVote()
                && candidate.getNationality().equals(PRESIDENT_NATIONALITY)
                && candidate.getAge() >= PRESIDENT_AGE
                && periodInUkraine >= PRESIDENT_IN_UKRAINE;
        return trueCandidate;
    }
}
