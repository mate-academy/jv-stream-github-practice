package practice;

import java.util.Arrays;
import java.util.Objects;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String ALLOWED_NATIONALITY = "Ukrainian";
    private static final int ALLOWED_CANDIDATE_AGE = 35;
    private static final int ALLOWED_PERIOD_OF_LIVING = 10;
    private static final String YEAR_PERIOD_SPLITTER = "-";

    @Override
    public boolean test(Candidate candidate) {
        String[] periodsInUkraine = candidate.getPeriodsInUkr()
                .split(YEAR_PERIOD_SPLITTER);
        int periodInUkraine = Arrays.stream(periodsInUkraine)
                .mapToInt(Integer::parseInt)
                .reduce((fromYear, toYear) -> toYear - fromYear)
                .orElseThrow();
        return candidate.isAllowedToVote()
                && Objects.equals(candidate.getNationality(), ALLOWED_NATIONALITY)
                && candidate.getAge() >= ALLOWED_CANDIDATE_AGE
                && periodInUkraine > ALLOWED_PERIOD_OF_LIVING;
    }
}
