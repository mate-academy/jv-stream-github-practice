package practice;

import java.util.Arrays;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    @Override
    public boolean test(Candidate candidate) {
        return candidate.isAllowedToVote() && candidate.getAge() >= 35
                && candidate.getNationality().equals("Ukrainian")
                && calcPeriodInUkr(candidate.getPeriodsInUkr()) >= 10;
    }

    private int calcPeriodInUkr(String period) {
        return Arrays.stream(period.split("-"))
                .mapToInt(Integer::parseInt)
                .reduce((startYear, endYear) -> endYear - startYear)
                .orElse(0);
    }
}
