package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String UKRAINIAN_NATIONALITY = "Ukrainian";
    private static final int CORRECT_CANDIDATE_AGE = 35;
    private static final int MINIMAL_LIVING_AGE = 10;

    @Override
    public boolean test(Candidate candidate) {
        boolean isAdult = candidate.getAge() >= CORRECT_CANDIDATE_AGE;
        boolean isUkrainian = candidate.getNationality().equals(UKRAINIAN_NATIONALITY);
        return isUkrainian
                && isAdult
                && candidate.isAllowedToVote()
                && checkCandidateForLiving(candidate);
    }

    private boolean checkCandidateForLiving(Candidate candidate) {
        String[] periodsInUkr = candidate.getPeriodsInUkr().split("-");
        int startYear = Integer.parseInt(periodsInUkr[0]);
        int endYear = Integer.parseInt(periodsInUkr[1]);
        return endYear - startYear >= MINIMAL_LIVING_AGE;
    }
}
