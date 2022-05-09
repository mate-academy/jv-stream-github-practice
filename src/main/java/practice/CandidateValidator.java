package practice;

import java.util.Arrays;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MINIMAL_CANDIDATE_AGE = 35;
    private static final String NATIONALITY = "Ukrainian";
    private static final int MINIMAL_YEARS_IN_COUNTRY = 10;

    @Override
    public boolean test(Candidate candidate) {
        Integer[] periodInUkr =
        Arrays.stream(candidate.getPeriodsInUkr().split("-"))
                .map(Integer::parseInt).toArray(Integer[]::new);
        if (candidate.getAge() >= MINIMAL_CANDIDATE_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && (periodInUkr[1] - periodInUkr[0] + 1) > MINIMAL_YEARS_IN_COUNTRY) {
            return true;
        }
        return false;
    }
}
