package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    //write your code here
    private static final int MINIMAL_CANDIDATE_AGE = 35;
    private static final int REQUIRED_LIVING_YEARS = 10;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MINIMAL_CANDIDATE_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(REQUIRED_NATIONALITY)
                && isCandidateLiveForTenYears(candidate);
    }

    private boolean isCandidateLiveForTenYears(Candidate candidate) {
        String[] periodsSplit = candidate.getPeriodsInUkr().split("-");
        int firstDate = Integer.parseInt(periodsSplit[0]);
        int secondDate = Integer.parseInt(periodsSplit[1]);
        return secondDate - firstDate >= REQUIRED_LIVING_YEARS;
    }
}
