package practice;

import java.util.Arrays;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {

    @Override
    public boolean test(Candidate candidate) {
        return isValidCandidate(candidate);
    }

    private static boolean isValidCandidate(Candidate candidate) {
        return candidate.getNationality().equals("Ukrainian")
                && candidate.isAllowedToVote()
                && candidate.getAge() >= 35
                && getYearsFromPeriod(candidate.getPeriodsInUkr()) >= 10;
    }

    private static int getYearsFromPeriod(String periodsInUkr) {
        return Arrays.stream(periodsInUkr.split("-"))
                .map(Integer::valueOf)
                .mapToInt(i -> i)
                .reduce(0, (left, right) -> right - left);

    }
}
