package practice;

import java.util.Arrays;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_YEARS = 10;

    @Override
    public boolean test(Candidate candidate) {
        int[] period = Arrays.stream(candidate.getPeriodsInUkr().split("-"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int isMoreThenTen = period[1] - period[0];
        return isMoreThenTen >= MIN_YEARS;
    }
}
