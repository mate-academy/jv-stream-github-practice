package practice;

import java.util.Arrays;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MINIMUM_AGE = 35;
    private static final String ALLOWED_NATIONALITY = "Ukrainian";
    private static final int PERIODS_IN_UKRAINE = 10;

    @Override
    public boolean test(Candidate candidate) {
        String[] splitYears = candidate.getPeriodsInUkr().split("-");
        int years = Arrays.stream(splitYears)
                .mapToInt(Integer::parseInt)
                .reduce((x, y) -> y - x).getAsInt();
        return candidate.getAge() >= MINIMUM_AGE
                && candidate.getNationality().equals(ALLOWED_NATIONALITY)
                && years > PERIODS_IN_UKRAINE && candidate.isAllowedToVote();
    }
}

