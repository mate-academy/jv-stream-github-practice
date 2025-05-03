package practice;

import java.util.Arrays;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int minimumAge = 35;
    private static final int minPeriodInUkraine = 10;
    private static final String nationality = "Ukrainian";
    private static final String periodSplitter = "-";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.isAllowedToVote() && candidate.getAge() >= minimumAge
                && candidate.getNationality().equals(nationality)
                && calcPeriodInUkr(candidate.getPeriodsInUkr()) >= minPeriodInUkraine;
    }

    private int calcPeriodInUkr(String period) {
        return Arrays.stream(period.split(periodSplitter))
                .mapToInt(Integer::parseInt)
                .reduce((startYear, endYear) -> endYear - startYear)
                .orElse(0);
    }
}
