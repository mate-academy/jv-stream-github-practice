package practice;

import model.Candidate;

import java.util.Arrays;
import java.util.function.Predicate;

public class CandidateValidator implements Predicate<Candidate> {
    public static final int REQUIRED_AGE = 35;
    public static final String NATIONALITY = "Ukrainian";
    public static final String DASH = "-";
    public static final int LIVING_YEARS_IN_UKR = 10;

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
