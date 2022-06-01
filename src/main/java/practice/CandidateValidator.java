package practice;

import java.util.Arrays;
import java.util.function.Predicate;
import java.util.stream.Stream;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_YEARS_FOR_CANDIDATE = 35;
    private static final int MIN_YEARS_LIVE_IN_UKRAINE = 10;
    private static final String NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        int yearsLiveInUkraine = Stream.of(candidate.getPeriodsInUkr())
                .map(s -> s.split("-"))
                .flatMapToInt(s -> Arrays.stream(s).mapToInt(Integer::parseInt))
                .reduce((n1, n2) -> n2 - n1)
                .orElseThrow(RuntimeException::new);

        return candidate.isAllowedToVote()
                && candidate.getAge() >= MIN_YEARS_FOR_CANDIDATE
                && candidate.getNationality().equals(NATIONALITY)
                && yearsLiveInUkraine > MIN_YEARS_LIVE_IN_UKRAINE;
    }
}
