package practice;

import java.util.Arrays;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int REQUIRED_AGE = 35;
    private static final String NATIONALITY = "Ukrainian";
    private static final String DASH = "-";
    private static final int LIVING_YEARS_IN_UKR = 10;

    @Override
    public boolean test(Candidate candidate) {
        String[] splitPeriod = candidate.getPeriodsInUkr().split(DASH);
        Integer yearsLivedInUkraine = Arrays.stream(splitPeriod)
                .map(Integer::valueOf)
                .reduce((starYear, endYear) -> endYear - starYear)
                .orElseThrow();
        return candidate.getAge() >= REQUIRED_AGE
                && candidate.getNationality().equals(NATIONALITY)
                && candidate.isAllowedToVote()
                && yearsLivedInUkraine >= LIVING_YEARS_IN_UKR;
    }
}
