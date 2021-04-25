package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MINIMUM_AGE = 35;
    private static final String NATIONALITY_REQUIRED = "Ukrainian";
    private static final int YEARS_STRAIGHT_IN_UKRAINE = 10;

    public static boolean checkCandidate(Candidate candidate) {
        String[] yearsInUkraine = candidate.getPeriodsInUkr().split("-");
        return candidate.getAge() >= MINIMUM_AGE
                && candidate.getNationality().equals(NATIONALITY_REQUIRED)
                && Integer.parseInt(yearsInUkraine[1])
                - Integer.parseInt(yearsInUkraine[0]) >= YEARS_STRAIGHT_IN_UKRAINE
                && candidate.isAllowedToVote();
    }

    @Override
    public boolean test(Candidate candidate) {
        return checkCandidate(candidate);
    }
}
