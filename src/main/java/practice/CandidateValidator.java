package practice;

import java.util.Arrays;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int requiredAge = 35;
    private static final int requaredYears = 10;
    private static final String requaredNationality = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        return isValidCandidate(candidate);
    }

    private static boolean isValidCandidate(Candidate candidate) {
        return candidate.getNationality().equals(requaredNationality)
                && candidate.isAllowedToVote()
                && candidate.getAge() >= requiredAge
                && getYearsFromPeriod(candidate.getPeriodsInUkr()) >= requaredYears;
    }

    private static int getYearsFromPeriod(String periodsInUkr) {
        return Arrays.stream(periodsInUkr.split("-"))
                .map(Integer::valueOf)
                .mapToInt(i -> i)
                .reduce(0, (left, right) -> right - left);

    }
}
