package practice;

import model.Candidate;

import java.util.function.Predicate;

public class CandidateValidator implements Predicate<Candidate> {
    //write your code here
    private static final int MINIMAL_CANDIDATE_AGE = 35;
    private static final int REQUIRED_LIVING_YEARS = 10;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MINIMAL_CANDIDATE_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals("Ukrainian")
                && isCandidateLiveForTenYears(candidate);
    }

    private boolean isCandidateLiveForTenYears(Candidate candidate) {
        String[] periodsSplit = candidate.getPeriodsInUkr().split("-");
        int firstDate = Integer.parseInt(periodsSplit[0]);
        int secondDate = Integer.parseInt(periodsSplit[1]);
        return secondDate - firstDate > REQUIRED_LIVING_YEARS;
    }
}
