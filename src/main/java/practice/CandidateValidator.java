package practice;

import java.util.Arrays;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int AGE_REQUIREMENT = 35;
    private static final String UKRAINE_NATIONALITY = "Ukrainian";
    private static final int LIVE_IN_COUNTRY_REQUIREMENT = 10;
    private static final String SEPARATOR = "-";

    @Override
    public boolean test(Candidate candidate) {
        return checkAge(candidate.getAge())
                && checkNationality(candidate.getNationality())
                && checkPeriodInUkraine(candidate.getPeriodsInUkr())
                && candidate.isAllowedToVote();
    }

    private boolean checkAge(int age) {
        return age >= AGE_REQUIREMENT;
    }

    private boolean checkNationality(String nationality) {
        return nationality.equals(UKRAINE_NATIONALITY);
    }

    private boolean checkPeriodInUkraine(String period) {
        return Arrays.stream(period.split(SEPARATOR))
                .map(Integer::valueOf)
                .reduce((a, b) -> b - a)
                .map(i -> i >= LIVE_IN_COUNTRY_REQUIREMENT)
                .get();
    }
}
