package practice;

import java.util.Arrays;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_PERIOD_OF_STAY = 10;
    private static final int MIN_AGE = 35;
    private static final String regex = "-";
    private static final String nationality = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        String[] years = candidate.getPeriodsInUkr().split(regex);
        Integer periodOfStay = Arrays.stream(years)
                .map(Integer::parseInt)
                .reduce((a, b) -> b - a)
                .orElseThrow(RuntimeException::new);
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(nationality)
                && periodOfStay >= MIN_PERIOD_OF_STAY;
    }
}
