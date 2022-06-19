package practice;

import java.util.Arrays;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int MIN_YEARS = 10;
    private static final String NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        return (candidate.getAge() >= MIN_AGE) && candidate.isAllowedToVote()
                && (candidate.getNationality().equals(NATIONALITY))
                && (getPeriodInUkr(candidate.getPeriodsInUkr()) >= MIN_YEARS);
    }

    private int getPeriodInUkr(String periodsInUkraine) {
        return Arrays.stream(periodsInUkraine.split("-"))
                .mapToInt(Integer::parseInt)
                .reduce((firstYear, secondYear) -> secondYear - firstYear)
                .getAsInt();
    }
}
