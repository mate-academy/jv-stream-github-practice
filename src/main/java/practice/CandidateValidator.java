package practice;

import java.util.Arrays;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    //write your code here
    private static final int REQUIRED_AGE = 35;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";
    private static final int REQUIRED_RESIDENCE_YEARS = 10;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= REQUIRED_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(REQUIRED_NATIONALITY)
                && Arrays.stream(candidate.getPeriodsInUkr().split("-"))
                .mapToInt(Integer::valueOf)
                .reduce((x, y) -> y - x)
                .orElse(0) >= REQUIRED_RESIDENCE_YEARS;
    }
}
