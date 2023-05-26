package practice;

import java.util.Arrays;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final String NATIONALITY = "Ukrainian";
    private static final int MIN_YEARS_IN_UKRAINE = 10;

    public static boolean isEligibleForPresident(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && meetsYearsInUkraineRequirement(candidate.getPeriodsInUkr());
    }

    @Override
    public boolean test(Candidate candidate) {
        return isEligibleForPresident(candidate);
    }

    private static boolean meetsYearsInUkraineRequirement(String periodsInUkr) {
        int totalYearsInUkraine = Arrays.stream(periodsInUkr.split(","))
                .mapToInt(StreamPractice::calculateYearsInUkraine)
                .sum();
        return totalYearsInUkraine >= MIN_YEARS_IN_UKRAINE;
    }
}
