package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String SLASH_SEPARATOR = "-";
    private static final int MINIMAL_CANDIDATE_AGE = 35;
    private static final String NATIONALITY = "Ukrainian";
    private static final int MINIMAL_PERIOD_IN_UKR = 10;

    @Override
    public boolean test(Candidate candidate) {
        return validCandidateAge(candidate) && validNationality(candidate)
                && validPeriodInUkr(candidate) && candidate.isAllowedToVote();
    }

    private boolean validCandidateAge(Candidate candidate) {
        return candidate.getAge() >= MINIMAL_CANDIDATE_AGE;
    }

    private boolean validNationality(Candidate candidate) {
        return candidate.getNationality().equals(NATIONALITY);
    }

    private boolean validPeriodInUkr(Candidate candidate) {
        String[] periodParts = candidate.getPeriodsInUkr().split(SLASH_SEPARATOR);
        int startYearInUkraine = Integer.parseInt(periodParts[0]);
        int lastYearInUkraine = Integer.parseInt(periodParts[1]);
        return lastYearInUkraine - startYearInUkraine >= MINIMAL_PERIOD_IN_UKR;

    }
}
