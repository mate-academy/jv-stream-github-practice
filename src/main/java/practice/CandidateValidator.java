package practice;

import java.util.Arrays;
import java.util.function.Predicate;
import java.util.stream.Stream;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    public static final int MIN_PERIOD_IN_UKR = 10;
    public static final String COUNTRY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= 35
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(COUNTRY)
                && isValidPeriod(candidate.getPeriodsInUkr());
    }

    private boolean isValidPeriod(String periodsInUkr) {
        if (periodsInUkr == null) {
            return false;
        }

        int asInt = Stream.of(periodsInUkr).map(p -> p.split("-"))
                .flatMap(Arrays::stream)
                .mapToInt(Integer::parseInt)
                .reduce((y1, y2) -> y2 - y1)
                .getAsInt();
        return asInt >= MIN_PERIOD_IN_UKR;
    }
}
