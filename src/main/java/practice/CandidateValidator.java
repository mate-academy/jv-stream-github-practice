package practice;

import java.util.Arrays;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE_RUN_PRESIDENT = 35;
    private static final int PERIOD_IN_UKRAINE = 10;
    private static final String NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE_RUN_PRESIDENT
                && candidate.getNationality().equals(NATIONALITY)
                && candidate.isAllowedToVote()
                && getYearsInUkraine(candidate.getPeriodsInUkr()) >= PERIOD_IN_UKRAINE;
    }

    private int getYearsInUkraine(String periodInUkraine) {
        return Arrays.stream(periodInUkraine.split("-"))
                .mapToInt(Integer::valueOf)
                .reduce((a, b) -> b - a)
                .getAsInt();
    }
}
