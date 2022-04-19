package practice;

import java.util.Arrays;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_YEARS_LIVE_IN_UA = 10;

    @Override
    public boolean test(Candidate candidate) {
        if (candidate.getAge() >= 35
                && candidate.getNationality().toLowerCase().equals("ukrainian")
                && candidate.isAllowedToVote()
                && getDifferenceBetweenYears(candidate) >= MIN_YEARS_LIVE_IN_UA) {
            return true;
        }
        return false;
    }

    private int getDifferenceBetweenYears(Candidate candidate) {
        return Arrays.stream(candidate.getPeriodsInUkr().split("-"))
                .mapToInt(Integer::parseInt)
                .reduce((s1, s2) -> s2 - s1).orElse(0);
    }
}
