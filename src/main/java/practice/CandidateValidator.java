package practice;

import java.util.Arrays;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int MIN_PERIOD = 10;
    private static final String NATION = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        String [] strings = candidate.getPeriodsInUkr().split("-");
        int period = Arrays.stream(strings)
                .mapToInt(Integer::parseInt)
                .reduce((data1, data2) -> data2 - data1).getAsInt();
        return candidate.getAge() >= MIN_AGE && candidate.getNationality().equals(NATION)
                && candidate.isAllowedToVote() && period >= MIN_PERIOD;
    }
}
